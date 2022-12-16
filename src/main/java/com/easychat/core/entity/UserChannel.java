package com.easychat.core.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_channel")
public class UserChannel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="channel_id", nullable=false)
    private Channel channel;

    public UserChannel() {
    }

    public UserChannel(User user, Channel channel) {
        this.user = user;
        this.channel = channel;
    }
}
