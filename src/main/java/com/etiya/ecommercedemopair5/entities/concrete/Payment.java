package com.etiya.ecommercedemopair5.entities.concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="payment")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @JoinColumn(name="discount_amount")
    private double discountAmount;

    @JoinColumn(name="payment_type")
    private String paymentType;

//    @OneToMany(mappedBy = "orders")
//    private List<Order> orders;
}
