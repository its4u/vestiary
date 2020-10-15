package com.bil.vestiary.rest;

import com.bil.vestiary.freemaker.FreeMakerService;
import com.bil.vestiary.freemaker.MetadataFileForGenerateTemplate;
import com.bil.vestiary.persistence.repository.MessageTypeRepository;
import com.bil.vestiary.persistence.repository.TemplateRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;

@Controller
public class TemplateRestController {

    private static Logger logger = Logger.getLogger(TemplateRestController.class);

    @Autowired
    private MessageTypeRepository messageTypeRepository;

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private FreeMakerService freeMakerService;

    @ResponseBody
    @GetMapping("/template/{templateID}")
    public String getTemplate(@PathVariable String templateID) {
        return new String(templateRepository.findById(templateID).orElseThrow(() -> new EntityNotFoundException(templateID)).getFulltemplate());
    }

    @ResponseBody
    @PostMapping(value = "/generateTemplate")
    public String generateTemplate(@RequestPart("metadataFileForGenerateTemplate") MetadataFileForGenerateTemplate metadataFileForGenerateTemplate, @RequestPart("xsdfile") MultipartFile file) {
        try {
            return  freeMakerService.generateTemplateToVestiary(metadataFileForGenerateTemplate,file);
        } catch (IOException|InstantiationException|IllegalAccessException|ClassNotFoundException e) {
            logger.error(e);
        }
        return null;
    }
}
