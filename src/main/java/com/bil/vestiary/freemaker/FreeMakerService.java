package com.bil.vestiary.freemaker;

import com.bil.vestiary.persistence.entity.MxMessageMetadata;
import com.bil.vestiary.persistence.entity.Undressedmessage;
import freemarker.template.Template;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public interface FreeMakerService {

    public void loadTemplatesFromVestiary();

    public void saveTemplateToVestiary(ByteArrayOutputStream outputStream, String templateID, String templateName, String idMessageType);

    public Template getFreeMakerTemplate(String templateID) throws IOException;

    public String generateTemplateToVestiary(MetadataFileForGenerateTemplate metadataFileForGenerateTemplate, MultipartFile file) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException;

    Undressedmessage processATemplateAsUndressedMessage(MxMessageMetadata mxMessageMetadata, Document messageIn) throws IOException;

}
