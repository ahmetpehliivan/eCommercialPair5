package com.etiya.ecommercedemopair5.entities.concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Table(name="invoice")
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @OneToMany(mappedBy = "invoice")
//    private List<IndividualCustomer> individualCustomers;

//    @OneToMany(mappedBy = "invoice")
//    private List<CommercialCustomer> commercialCustomers;

    @ManyToOne
    @JoinColumn(name="products_order")
    private ProductOrder productOrder;
}
