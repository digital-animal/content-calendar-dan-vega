package com.zahid.content.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.zahid.person.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "content")
@NoArgsConstructor
public class Content extends BaseEntity {
    @Getter
    @Setter
    @NotBlank
    private String title;
    
    @Getter
    @Setter
    @NotBlank
    private String description;
    
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private ContentType type;
    
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private StatusType Status;
    
    @Getter
    @Setter
    @NotBlank
    private String url;

    public Content(String title, String description, ContentType type, StatusType status, String url) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.Status = status;
        this.url = url;
    }
}
