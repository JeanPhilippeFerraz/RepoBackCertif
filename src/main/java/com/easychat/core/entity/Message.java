package com.easychat.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length=500)
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="channel_id", nullable=false)
    private Channel channel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Message() {
    }

    public Message(String text, Channel channel, User user, Timestamp created_at, Timestamp updated_at) {
        this.text = text;
        this.channel = channel;
        this.user = user;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Message(Integer id, String text, Channel canal, User user, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.text = text;
        this.channel = canal;
        this.user = user;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
