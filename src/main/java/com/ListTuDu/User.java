package com.ListTuDu;

import javax.persistence.*;

@Entity
@Table(name="user_login")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_login_id", unique = true)
    private Long user_login_id;
    @Column(name = "user_login_email")
    private String email;
    @Column(name = "user_login_pass")
    private String pass;


    public Long getId() {
        return user_login_id;
    }
    public String getEmail() {
        return email;
    }
    public String getPass() {
        return pass;
    }

    public void setId(Long user_login_id) {
        this.user_login_id = user_login_id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
