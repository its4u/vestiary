package com.bil.vestiary.freemaker;

import com.bil.vestiary.persistence.entity.Messagetype;
import com.bil.vestiary.persistence.entity.MxMessageMetadata;
import com.bil.vestiary.persistence.entity.Template;
import com.bil.vestiary.persistence.entity.Undressedmessage;
import com.bil.vestiary.persistence.repository.MessageTypeRepository;
import com.bil.vestiary.persistence.repository.TemplateRepository;
import com.bil.vestiary.persistence.repository.TemplateRepositoryService;
import com.bil.vestiary.uuid.UUIDFactory;
import com.bil.vestiary.xpath.XPathService;
import com.bil.xsd.parser.XSDElement;
import com.bil.xsd.parser.XSDParser;
import freemarker.cache.StringTemplateLoader;
import freemarker.ext.dom.NodeModel;
import freemarker.template.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.persistence.EntityNotFoundException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;

@Service
public class FreeMakerServiceImpl implements FreeMakerService {

    @Autowired
    private XPathService xPathService;

    @Autowired
    private TemplateRepositoryService templateRepositoryService;

    private static Logger logger = Logger.getLogger(FreeMakerServiceImpl.class);

    private Configuration freeMakerConfig;

    private static String header ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private static String rootElement = "Document";

    public FreeMakerServiceImpl() {
        try {
            this.freeMakerConfig = new FreeMarkerConfigurationFactory().createConfiguration();
            this.freeMakerConfig.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
            this.freeMakerConfig.setDefaultEncoding("UTF-8");
            DefaultObjectWrapperBuilder owb = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_27);
            owb.setForceLegacyNonListCollections(false);
            owb.setDefaultDateType(TemplateDateModel.DATETIME);
            this.freeMakerConfig.setObjectWrapper(owb.build());
        } catch (IOException|TemplateException e) {
            logger.error(e);
        }
    }

    @Autowired
    private MessageTypeRepository messageTypeRepository;

    @Autowired
    private TemplateRepository templateRepository;


    public Undressedmessage processATemplateAsUndressedMessage(MxMessageMetadata mxMessageMetadata, Document messageIn) throws IOException {
        Template tp = templateRepositoryService.selectionTemplate(mxMessageMetadata.getMsgType(),null,mxMessageMetadata.getOrigin(),null,"IN");
        freemarker.template.Template temp= getFreeMakerTemplate(tp.getTemplateId());
        HashMap<String, NodeModel> mapIn  = new HashMap<>();
        try {
            mapIn.put("MsgSRC", NodeModel.parse(new InputSource(xPathService.document2InputStream(messageIn))));
        } catch (SAXException | ParserConfigurationException | TransformerException e) {
            logger.error(e);
        }
        StringWriter out = new StringWriter();
        try {
            temp.process(mapIn, out);
        } catch (TemplateException e) {
            logger.error(e);
        }
        Undressedmessage undressedmessage= new Undressedmessage();
        undressedmessage.setUndressedmessageUuid(UUIDFactory.getInstance().newUUID().toString());
        undressedmessage.setRelatedTemplateId(tp.getTemplateId());
        undressedmessage.setFullUndressedMessage(out.toString().getBytes());
        return undressedmessage;
    }

    public void loadTemplatesFromVestiary() {
        Iterable<Template> templates=templateRepository.findAll();
        StringTemplateLoader loader = new StringTemplateLoader();
        templates.forEach(template -> loader.putTemplate(template.getTemplateId(),new String(template.getFulltemplate())));
        this.freeMakerConfig.setTemplateLoader(loader);
    }

    public void saveTemplateToVestiary(ByteArrayOutputStream outputStream, String templateID, String templateName, String idMessageType) {

        Messagetype messagetype = messageTypeRepository.findById(idMessageType).orElseThrow(() -> new EntityNotFoundException(idMessageType));
        Template template = new Template(templateID,templateName);
        template.setFulltemplate(outputStream.toByteArray());
        template.setMessageType(messagetype);
    }

    public freemarker.template.Template getFreeMakerTemplate(String templateID) throws IOException {
        return freeMakerConfig.getTemplate(templateID);
    }

    public String generateTemplateToVestiary(MetadataFileForGenerateTemplate metadataFileForGenerateTemplate, MultipartFile file) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        InputStream streamXSDFile = file.getInputStream();
        XSDElement mainElement = XSDParser.parseXSD(streamXSDFile, rootElement,metadataFileForGenerateTemplate.getNamespace());
        StringBuilder stringBuilder = new StringBuilder();
        // GENERATE TEMPLATE
        stringBuilder.append(header);
        stringBuilder.append(System.getProperty("line.separator"));
        GenerateTemplateFromXSDinString.printData(mainElement, 0, stringBuilder,metadataFileForGenerateTemplate, rootElement);

        Messagetype messagetype = messageTypeRepository.findById(metadataFileForGenerateTemplate.getMsgType()).orElseThrow(() -> new EntityNotFoundException(metadataFileForGenerateTemplate.getMsgType()));

        Template newtempTemplate = new Template(metadataFileForGenerateTemplate.getTemplateID(),metadataFileForGenerateTemplate.getTemplateName());
        newtempTemplate.setMessageType(messagetype);
        newtempTemplate.setFulltemplate(stringBuilder.toString().getBytes());
        templateRepository.save(newtempTemplate);
        return stringBuilder.toString();
    }


}
