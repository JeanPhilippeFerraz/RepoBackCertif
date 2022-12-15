package com.easychat.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name="users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(length=50)
    private String username;
    @Column(length=100)
    private String email;
    @Column(length=50)
    private String password;

    @OneToMany(mappedBy="user")
    private Set<Message> messages;

    public User() {
    }

    public User(Integer id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
