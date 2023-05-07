package com.etiya.ecommercedemopair5.entities.concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name="attributes")
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Attribute {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="attribute_name")
    private String attributeName;

    @Column(name="value")
    private String value;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "attribute")
    private List<ProductAttribute> productAttribute;
}
