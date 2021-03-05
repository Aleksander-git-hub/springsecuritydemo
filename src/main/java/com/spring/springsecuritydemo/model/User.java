package com.spring.springsecuritydemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String lastName;

    @Column
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Status status;
}
