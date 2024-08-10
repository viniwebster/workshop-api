package com.viniwebs.workshop.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class CommentDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String comment;
    private AuthorDto author;
    private Date date;

    public CommentDto() {}

    public CommentDto(String comment, AuthorDto author, Date date) {
        this.comment = comment;
        this.author = author;
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
