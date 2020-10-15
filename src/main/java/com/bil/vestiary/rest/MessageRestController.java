package com.bil.vestiary.rest;

import com.bil.vestiary.getmessage.GetMessageService;
import com.bil.vestiary.persistence.entity.MxMessageMetadata;
import com.bil.vestiary.persistence.entity.Undressedmessage;
import com.bil.vestiary.storagemessages.StorageMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MessageRestController {

    private static Logger logger = Logger.getLogger(MessageRestController.class);

    @Autowired
    private StorageMessageService storeMessageService;

    @Autowired
    private GetMessageService getMessageService;


    @ResponseBody
    @PostMapping(value = "/message/storemessage")
    public Undressedmessage storeMessage(@RequestPart("mxMessageMetadata") MxMessageMetadata mxMessageMetadata, @RequestPart("fullMessage")MultipartFile file) {
        Undressedmessage undressedmessage = null;
        try {
            undressedmessage = storeMessageService.storeMessageToVestiary(mxMessageMetadata,file);
        } catch (IOException e) {
            logger.error(e);
        }
        return undressedmessage;
    }

    @ResponseBody
    @GetMapping("/message/undressedmessage/{undressedmsgID}")
    public String getUndressedMessage(@PathVariable String undressedmsgID) {
        return String.valueOf(getMessageService.getUndressedMessage(undressedmsgID).getFullUndressedMessage());
    }

    @ResponseBody
    @GetMapping("/message/messageinstore/{messageinstoreID}")
    public String getInStoreMessage(@PathVariable String messageinstoreID) {
        return String.valueOf(getMessageService.getMessageInStore(messageinstoreID).getFullmessage());
    }
}
