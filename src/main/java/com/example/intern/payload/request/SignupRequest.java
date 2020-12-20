package com.example.intern.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {
    @NotNull
    @Size(min = 3, max = 20)
    private String username;

//    @NotNull
//    @Size(max = 50)
//    @Email
//    private String email;

    private Set<String> role;

    @NotNull
    @Size(min = 6, max = 40)
    private String password;

    @NotNull
    private String sdt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    //    public Set<String> getRole() {
//        return this.role;
//    }
//
//    public void setRole(Set<String> role) {
//        this.role = role;
//    }
}
