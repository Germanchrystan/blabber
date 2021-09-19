package com.blabber.blabber.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "follow")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private int id;
    @Getter @Setter @Column(name="followerId")
    private int followerId;
    @Getter @Setter @Column(name="followedId")
    private int followedId;
}
