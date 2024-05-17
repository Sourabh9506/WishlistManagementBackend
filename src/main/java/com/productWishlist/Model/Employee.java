package com.productWishlist.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    @Column(unique=true)
    private String email;
    private String enable;
    private String role;
    private Boolean isAccountNotLocked;
    private Integer failedAttempt;

    public Employee(String name,String email){
        this.name=name;
        this.email=email;
    }
}
