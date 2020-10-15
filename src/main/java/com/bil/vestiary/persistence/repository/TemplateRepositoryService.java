package com.bil.vestiary.persistence.repository;

import com.bil.vestiary.persistence.entity.Template;
import com.bil.vestiary.persistence.entity.Templateselection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TemplateRepositoryService {

    public Template selectionTemplate(String msgtypeExposed, String msgTypeOut, String origin, String destination, String inOut);

    public List<Templateselection> getSelectionTemplate(String msgtypeExposed, String msgTypeOut, String origin, String destination, String inOut);

}

