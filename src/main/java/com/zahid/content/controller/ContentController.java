package com.zahid.content.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.zahid.content.model.Content;
import com.zahid.content.service.ContentService;

@CrossOrigin
@RestController
@RequestMapping("/api/content")
public class ContentController {
    
    @Autowired
    private ContentService contentService;

    @GetMapping("/all")
    public List<Content> getAllEntities() {
        return contentService.getAllEntities();
    }

    @GetMapping("/search/{title}")
    public List<Content> getEntitiesByTitle(@PathVariable("title") String title) {
        return contentService.getEntitiesByTitle(title);
    }

    @GetMapping("/{id}")
    public Content getAllEntityById(@PathVariable("id") UUID id) {
        return contentService.getEntityById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public Content createEntity(@Valid @RequestBody Content content) {
        return contentService.createEntity(content);
    }

    @PutMapping("/update/{id}")
    public Content updateEntity(@PathVariable("id") UUID id, @RequestBody Content content) {
        return contentService.updateEntity(id, content);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteEntityById(@PathVariable("id") UUID id) {
        return contentService.deleteEntityById(id);
    }

    @DeleteMapping("/delete/all")
    public Boolean deleteAllEntities() {
        return contentService.deleteAllEntities();
    }
}
