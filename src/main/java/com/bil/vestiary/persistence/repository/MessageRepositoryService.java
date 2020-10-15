package com.bil.vestiary.persistence.repository;

import com.bil.vestiary.persistence.entity.Messageinstore;
import com.bil.vestiary.persistence.entity.MxMessageMetadata;
import com.bil.vestiary.persistence.entity.Undressedmessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface MessageRepositoryService {

    public Messageinstore storeMessageToVestiary(MxMessageMetadata mxMessageMetadata, MultipartFile file) throws IOException;

    public Undressedmessage storeUndressedMessageToVestiary(String templateId, String originalMessageId, byte[] fullUndressedMessage);

    public Undressedmessage storeUndressedMessageToVestiary(Undressedmessage undressedmessage);
}
