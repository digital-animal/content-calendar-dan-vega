package com.zahid.content.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zahid.content.model.Content;
import com.zahid.content.repository.ContentJdbcTemplateRepository;
import com.zahid.content.repository.ContentRepository;


@Service
public class ContentServiceImplementation implements ContentService {
    @Autowired
    private ContentRepository contentRepository;

    @Autowired ContentJdbcTemplateRepository contentJdbcTemplateRepository;

    @Override
    public List<Content> getAllEntities() {
        // return contentRepository.findAllEntities();
        // return contentJdbcTemplateRepository.getAllContent();
        
        return contentRepository.findAll();
    }
    
    @Override
    public List<Content> getEntitiesByTitle(String title) {
        return contentRepository.findAllByTitle(title);
    }
    
    @Override
    public Content getEntityById(UUID id) {
        // return contentJdbcTemplateRepository.getContent(id);
        
        return contentRepository.findById(id).get();
    }
    
    @Override
    public Content createEntity(Content content) {
        return contentRepository.save(content);
    }
    
    @Override
    public Content updateEntity(UUID id, Content updatedContent) {
        
        Content content = getEntityById(id);
        content.setTitle(updatedContent.getTitle());
        content.setDescription(updatedContent.getDescription());
        content.setType(updatedContent.getType());
        content.setStatus(updatedContent.getStatus());
        content.setUrl(updatedContent.getUrl());
        content.setUpdatedAt(Instant.now());

        return contentRepository.save(content);
    }
    
    @Override
    public Boolean deleteEntityById(UUID id) {
        try {
            contentRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    @Override
    public Boolean deleteAllEntities() {
        try {
            contentRepository.deleteAll();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
