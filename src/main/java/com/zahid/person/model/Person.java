package com.zahid.person.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.zahid.person.BaseEntity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Data
// @Builder
@Entity
@NoArgsConstructor
@Table(name = "person")
public class Person extends BaseEntity {

    @Getter
    @Setter
    private String name;
    
    @Getter
    @Setter
    private String email;
    
    @Getter
    @Setter
    private String address;
    
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    
    @Getter
    @Setter
    private String profession;

    public Person(String name, String email, String address, GenderType gender, String profession) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.profession = profession;
    }  
}
