package com.zahid.content.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.zahid.content.model.Content;

@Service
public interface ContentService {

    public List<Content> getAllEntities();

    public List<Content> getEntitiesByTitle(String name);

    public Content getEntityById(UUID id);
    
    public Content createEntity(Content content);

    public Content updateEntity(UUID id, Content updatedContent);

    public Boolean deleteEntityById(UUID id);

    public Boolean deleteAllEntities();

}
