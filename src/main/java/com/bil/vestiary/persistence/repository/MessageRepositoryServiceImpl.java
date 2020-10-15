package com.bil.vestiary.persistence.repository;

import com.bil.vestiary.persistence.entity.*;
import com.bil.vestiary.uuid.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Date;

@Service
public class MessageRepositoryServiceImpl implements MessageRepositoryService {


    @Autowired
    private MessageInStoreRepository messageInStoreRepository;

    @Autowired
    private MessageTypeRepository messageTypeRepository;

    @Autowired
    private OrigindestinationRepository origindestinationRepository;

    @Autowired
    private UndressedmessageRepository undressedmessageRepository;

    public Messageinstore storeMessageToVestiary(MxMessageMetadata mxMessageMetadata, MultipartFile file) throws IOException {
        Messageinstore messageinstore = new Messageinstore();
        messageinstore.setMessageinstoreUuid(UUIDFactory.getInstance().newUUID().toString());
        messageinstore.setDatetime(new Date());
        Messagetype messagetype = messageTypeRepository.findById(mxMessageMetadata.getMsgType()).orElseThrow(() -> new EntityNotFoundException(mxMessageMetadata.getMsgType()));
        Origindestination origindestination = origindestinationRepository.findById(mxMessageMetadata.getOrigin()).orElseThrow(() -> new EntityNotFoundException(mxMessageMetadata.getOrigin()));
        messageinstore.setMessageType(messagetype);
        messageinstore.setFullmessage(file.getBytes());
        messageinstore.setOrigin(origindestination);
        messageInStoreRepository.save(messageinstore);
        return messageinstore;
    }

    public Undressedmessage storeUndressedMessageToVestiary(String templateId,String originalMessageId,byte[] fullUndressedMessage) {
        Undressedmessage undressedmessage= new Undressedmessage();
        undressedmessage.setUndressedmessageUuid(UUIDFactory.getInstance().newUUID().toString());
        undressedmessage.setRelatedTemplateId(templateId);
        undressedmessage.setOriginalMessageInStoreUuid(originalMessageId);
        undressedmessage.setFullUndressedMessage(fullUndressedMessage);
        undressedmessageRepository.save(undressedmessage);
        return undressedmessage;
    }

    public Undressedmessage storeUndressedMessageToVestiary(Undressedmessage undressedmessage) {
        undressedmessageRepository.save(undressedmessage);
        return undressedmessage;
    }
}
