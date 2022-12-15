package com.easychat.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Table(name = "channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=50)
    private String name;
    @Column(length=250)
    private String description;
    private Timestamp created_at;
    private Timestamp updated_at;

    @OneToMany(mappedBy="channel")
    private Set<Message> messages;

    public Channel() {
    }

    public Channel(String name, String description, Timestamp created_at, Timestamp updated_at) {
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Channel(Integer id, String name, String description, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
