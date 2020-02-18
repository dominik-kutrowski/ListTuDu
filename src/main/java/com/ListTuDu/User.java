package com.ListTuDu;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user_login")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_login_id", unique = true)
    private Long user_login_id;
    @Column(name = "user_login_email")
    @NotEmpty
    @Size(min = 2, max = 30)
    @Email
    private String email;
    @Column(name = "user_login_pass")
    @NotEmpty
    @Size(min = 1, max = 64)
    private String pass;
    @Column(name = "user_login_role")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        DoNotUse("Enum to adjust with MySQL db!"),
        User("User"),
        SuperUser("SuperUser"),
        Root("Root");

        private String role;

        Role(String role) {
            this.role = role;
        }
        public String getRole() {
            return role;
        }
        public void setRole(String role) {
            this.role = role;
        }
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

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
