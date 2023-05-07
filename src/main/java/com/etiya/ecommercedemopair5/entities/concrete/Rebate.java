package com.etiya.ecommercedemopair5.entities.concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Table(name="rebate")
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Rebate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rebate_description")
    private String rebateDescription;

    @Column(name = "rebate_date")
    private Date rebateDate;

//    @OneToMany(mappedBy = "products_order")
//    private List<ProductOrder> productOrders ;
}
