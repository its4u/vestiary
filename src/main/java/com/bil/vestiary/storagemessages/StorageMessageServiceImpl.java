package com.bil.vestiary.storagemessages;

import com.bil.vestiary.freemaker.FreeMakerService;
import com.bil.vestiary.persistence.entity.Messageinstore;
import com.bil.vestiary.persistence.entity.MxMessageMetadata;
import com.bil.vestiary.persistence.entity.Undressedmessage;
import com.bil.vestiary.persistence.repository.MessageRepositoryService;
import com.bil.vestiary.persistence.repository.TemplateRepositoryService;
import com.bil.vestiary.xpath.XPathService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.security.SecureRandom;

@Service
public class StorageMessageServiceImpl implements StorageMessageService {

    private static Logger logger = Logger.getLogger(StorageMessageServiceImpl.class);


    @Autowired
    private TemplateRepositoryService templateRepositoryService;

    @Autowired
    private MessageRepositoryService messageRepositoryService;

    @Autowired
    private XPathService xPathService;

    @Autowired
    private FreeMakerService freeMakerService;

    public StorageMessageServiceImpl() {
    }

    @Override
    public Undressedmessage storeMessageToVestiary(MxMessageMetadata mxMessageMetadata, MultipartFile file) throws IOException {

        // We store the Original Message
        Messageinstore messageinstore = messageRepositoryService.storeMessageToVestiary(mxMessageMetadata,file);

        // We transform the file in org.w3c.document for use xpath transformation as Needed
        Document document = null;
        try {
            document=xPathService.parseMessage(file.getInputStream());
            String expression = "/Document/FIToFICstmrCdtTrf/CdtTrfTxInf/PmtId/ClrSysRef";
            xPathService.setNodeValue(document,expression,getAlphaNumericString(10));

        } catch (ParserConfigurationException | SAXException e) {
            logger.error(e);
        }

        // Create and store undressed Message with the desired template
        Undressedmessage undressedmessage = freeMakerService.processATemplateAsUndressedMessage(mxMessageMetadata,document);
        undressedmessage.setOriginalMessageInStoreUuid(messageinstore.getMessageinstoreUuid());
        messageRepositoryService.storeUndressedMessageToVestiary(undressedmessage);
        return undressedmessage;
    }

    static String getAlphaNumericString(int n)
    {
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        SecureRandom random = new SecureRandom(); // Compliant for security-sensitive use cases

        for (int i = 0; i < n; i++) {
            int index
                    = (alphaNumericString.length()
                    * random.nextInt());
            sb.append(alphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
}
