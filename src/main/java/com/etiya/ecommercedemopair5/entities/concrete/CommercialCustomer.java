package com.etiya.ecommercedemopair5.entities.concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Table(name="commercial_customer")
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class CommercialCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fax_number")
    private String faxNumber;

    @Column(name = "tax_number")
    private String taxNumber;

    @ManyToOne
    @JoinColumn(name="invoice")
    private Invoice invoice;
}
