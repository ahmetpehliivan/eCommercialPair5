package com.etiya.ecommercedemopair5.entities.concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name="companies")
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Company {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="company_name")
    private String companyName;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="company_adress")
    private String companyAdress;

//    @OneToMany(mappedBy = "company")
//   private List<Employee> employees;

}
