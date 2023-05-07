package com.etiya.ecommercedemopair5.entities.concrete;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String  email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

    @ManyToOne
    @JoinColumn(name="comments_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name="commercial_customer_id")
    private CommercialCustomer commercialCustomer;

    @ManyToOne
    @JoinColumn(name = "individual_customer_id")
    private IndividualCustomer individualCustomer;

//    @OneToMany(mappedBy = "productOrder")
//   private List<ProductOrder> productOrders ;


}
