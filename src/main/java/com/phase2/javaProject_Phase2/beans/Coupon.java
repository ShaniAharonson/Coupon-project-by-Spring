package com.phase2.javaProject_Phase2.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "coupons")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer company_ID;

    @Column(nullable = false)
    private Integer category_ID;

    @Column(nullable = false) // exception for sql
    @Length(min = 1, max = 400) // exception for advice
    private String title;

    @Column(nullable = false, unique = true, length = 40)
    @Length(min = 10, max = 40)
    private String description;

    @Column(nullable = false)
    private Date start_date;

    @Column(nullable = false)
    private Date end_date;

    @Min(1)
    private Integer amount;

    @Min(1)
    private Double price;

    private String image;



    public Coupon(Integer company_ID, Integer category_ID, String title, String description,
                  Date start_date, Date end_date, Integer amount, Double price, String image) {
        this.company_ID = company_ID;
        this.category_ID = category_ID;
        this.title = title;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }
}
