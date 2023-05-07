package com.etiya.ecommercedemopair5.entities.concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="tck_no")
    private String tckNo;

    @Column(name="birth_of_date")
    private Date birthOfDate;

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="title")
    private String title;

    @Column(name="territory_description")
    private String territoryDescription;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

//    @OneToMany(mappedBy = "employees")
//    private List<Order> orders;


}