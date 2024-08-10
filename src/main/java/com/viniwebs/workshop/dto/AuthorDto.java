package com.viniwebs.workshop.dto;

import com.viniwebs.workshop.domain.User;

import java.io.Serial;
import java.io.Serializable;

public class AuthorDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDto(User obj) {
        this.id = obj.getId();
        this.name = obj.getUsername();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
