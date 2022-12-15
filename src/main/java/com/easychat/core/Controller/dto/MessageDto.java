package com.easychat.core.Controller.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MessageDto {

    private Integer id;
    private String text;
    private Integer canal_id;
    private Integer user_id;
    private Timestamp created_at;
    private Timestamp updated_at;

    public MessageDto() {
    }

    public MessageDto(Integer id, String text, Integer canal_id, Integer user_id, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.text = text;
        this.canal_id = canal_id;
        this.user_id = user_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
