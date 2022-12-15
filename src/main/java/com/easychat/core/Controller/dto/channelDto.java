package com.easychat.core.Controller.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ChannelDto {

    private Integer id;
    private String name;
    private String description;
    private Date created_at;
    private Date updated_at;

    public ChannelDto() {
    }

    public ChannelDto(Integer id, String name, String description, Date created_at, Date updated_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
