package com.phase2.javaProject_Phase2.beans;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CUSTOMERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 15)
    @Length(min = 3, max = 15)
    private String First_Name;

    @Column(nullable = false, length = 15)
    @Length(min = 5, max = 15)
    private String Last_Name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false, length = 13)
    @Length(min = 4, max = 13)
    private String password;

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @Singular
    private Set<Coupon> coupons;


}
