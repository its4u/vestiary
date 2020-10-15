package com.bil.vestiary.getmessage;

import com.bil.vestiary.persistence.entity.Messageinstore;
import com.bil.vestiary.persistence.entity.Undressedmessage;
import org.springframework.stereotype.Service;

@Service
public interface GetMessageService {

    public Messageinstore getMessageInStore(String messageInStoreUuid);

    public Undressedmessage getUndressedMessage(String undressedMessageUuid);
}
