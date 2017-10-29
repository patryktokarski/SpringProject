package com.spring.test.model;

import com.spring.test.model.User;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "password_token")
public class PasswordToken {
    private static final int EXPIRATION_IN_SECONDS = 60 * 60 * 24;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "token")
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(name = "expire_date")
    private Date expireDate;

    public PasswordToken(String token, User user) {
        this.token = token;
        this.user = user;
        Calendar date = Calendar.getInstance();
        long time = date.getTimeInMillis();
        this.expireDate = new Date(time + (EXPIRATION_IN_SECONDS * 1000));
    }

    public PasswordToken() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
