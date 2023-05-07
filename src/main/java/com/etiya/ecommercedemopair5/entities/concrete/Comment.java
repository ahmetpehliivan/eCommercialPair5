package com.etiya.ecommercedemopair5.entities.concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Table(name="comments")
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "answer")
    private String  answer;

//    @OneToMany(mappedBy = "customers")
//    private List<Customer> customers;

//    @OneToMany(mappedBy = "products")
//    private List<Product> products;

//    @OneToMany(mappedBy = "suppliers")
//    private List<Supplier> suppliers ;
}
