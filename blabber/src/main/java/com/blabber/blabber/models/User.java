package com.blabber.blabber.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private int id;
    @Getter @Setter @Column(name="username")
    private String username;
    @Getter @Setter @Column(name="atUser")
    private String atUser;
    @Getter @Setter @Column(name="email")
    private String email;
    @Getter @Setter @Column(name="password")
    private String password;
}
