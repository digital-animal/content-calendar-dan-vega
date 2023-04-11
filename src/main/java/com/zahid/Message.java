package com.zahid;

import org.springframework.stereotype.Component;

@Component
public class Message {

    public String getMessage() {
        return "Bean Creation Successful";
    }
}
