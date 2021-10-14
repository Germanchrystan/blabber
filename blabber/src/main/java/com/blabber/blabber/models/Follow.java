package com.blabber.blabber.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name= "follow")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @JoinColumn(name="followerId", referencedColumnName = "userId")
    private int followerId;
    @JoinColumn(name="followedId", referencedColumnName = "userId")
    private int followedId;
}
