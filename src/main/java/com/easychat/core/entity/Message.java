package com.easychat.core.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

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
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    public Message() {
    }

    public Message(String text, Channel channel, User user) {
        this.text = text;
        this.channel = channel;
        this.user = user;
    }

    public Message(String text, Channel channel, User user, Date created_at, Date updated_at) {
        this.text = text;
        this.channel = channel;
        this.user = user;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Message(Integer id, String text, Channel channel, User user, Date created_at, Date updated_at) {
        this.id = id;
        this.text = text;
        this.channel = channel;
        this.user = user;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
