package com.example.VetApp.entity;

import javax.persistence.*;

@Entity
@Table(name="user",uniqueConstraints = @UniqueConstraint(columnNames = "email" ))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    private String email;

    private String password;

    //fist deneme
    //oldu mu
}
