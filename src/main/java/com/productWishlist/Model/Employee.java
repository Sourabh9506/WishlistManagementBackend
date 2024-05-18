package com.productWishlist.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    @Column(unique=true)
    private String email;
    private Boolean enable;
    private String password;
    private String role;
    private String verificationCode;
    private Boolean isAccountNotLocked;
    private Integer failedAttempt;

    public Employee(String name,String email){
        this.name=name;
        this.email=email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getAccountNotLocked() {
        return isAccountNotLocked;
    }

    public void setAccountNotLocked(Boolean accountNotLocked) {
        isAccountNotLocked = accountNotLocked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getFailedAttempt() {
        return failedAttempt;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void setFailedAttempt(Integer failedAttempt) {
        this.failedAttempt = failedAttempt;
    }
}
