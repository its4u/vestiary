package com.bil.vestiary.storagemessages;

import com.bil.vestiary.persistence.entity.MxMessageMetadata;
import com.bil.vestiary.persistence.entity.Undressedmessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface StorageMessageService {

    public Undressedmessage storeMessageToVestiary(MxMessageMetadata mxMessageMetadata, MultipartFile file) throws IOException;


}
