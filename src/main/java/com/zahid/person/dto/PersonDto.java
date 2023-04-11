package com.zahid.person.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.zahid.person.model.GenderType;

import lombok.Getter;
import lombok.Setter;

public class PersonDto {
    
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

    public PersonDto() {
    }

    public PersonDto(String name, String email, String address, GenderType gender, String profession) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.profession = profession;
    }
}
