package com.bil.vestiary.getmessage;

import com.bil.vestiary.persistence.entity.Messageinstore;
import com.bil.vestiary.persistence.entity.Undressedmessage;
import com.bil.vestiary.persistence.repository.MessageInStoreRepository;
import com.bil.vestiary.persistence.repository.UndressedmessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class GetMessageServiceImpl implements  GetMessageService{

    @Autowired
    private MessageInStoreRepository messageInStoreRepository;

    @Autowired
    private UndressedmessageRepository undressedmessageRepository;

    @Override
    public Messageinstore getMessageInStore(String messageInStoreUuid) {
        return messageInStoreRepository.findById(messageInStoreUuid).orElseThrow(() -> new EntityNotFoundException(messageInStoreUuid));
    }

    @Override
    public Undressedmessage getUndressedMessage(String undressedMessageUuid) {
        return undressedmessageRepository.findById(undressedMessageUuid).orElseThrow(() -> new EntityNotFoundException(undressedMessageUuid));
    }
}
