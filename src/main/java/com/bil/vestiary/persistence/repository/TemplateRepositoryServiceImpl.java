package com.bil.vestiary.persistence.repository;

import com.bil.vestiary.persistence.entity.Template;
import com.bil.vestiary.persistence.entity.Templateselection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Service
public  class TemplateRepositoryServiceImpl implements TemplateRepositoryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TemplateRepository templateRepository;


    public Template selectionTemplate(String msgtypeExposed, String msgTypeOut, String origin, String destination, String inOut) {
        List<Templateselection> selection = getSelectionTemplate(msgtypeExposed,msgTypeOut,origin,destination,inOut);
        if (selection!=null && !selection.isEmpty()) {
            return selection.get(0).getRelatedTemplate();
        }
        return null;
    }

    @Override
    public List<Templateselection> getSelectionTemplate(String msgtypeExposed, String msgTypeOut, String origin, String destination, String inOut) {
        String hql = "SELECT e FROM Templateselection e WHERE e.inout= :inout AND e.messagetypeOfExposedmsg.msgtype = :msgtypeExposed AND e.originOfExposedmsg.odCode = :origin";
        TypedQuery<Templateselection> query= entityManager.createQuery(hql,Templateselection.class);
        query.setParameter("inout",inOut);
        query.setParameter("msgtypeExposed",msgtypeExposed);
        query.setParameter("origin",origin);
        return query.getResultList();
    }



}
