package com.easychat.core.Controller.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class channelDto {

    private Integer id;
    private String name;
    private String description;
    private Timestamp created_at;
    private Timestamp updated_at;

    public channelDto() {
    }

    public channelDto(Integer id, String name, String description, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
