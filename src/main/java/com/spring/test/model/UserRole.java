package com.spring.test.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "role_id")
    private int roleId;
}
