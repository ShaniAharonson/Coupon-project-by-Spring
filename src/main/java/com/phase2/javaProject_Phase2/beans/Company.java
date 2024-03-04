package com.phase2.javaProject_Phase2.beans;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "COMPANIES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    @Length(min = 5, max = 40)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 15)
    @Length(min = 5, max = 15)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @Singular
    private List<Coupon> coupons;

}
