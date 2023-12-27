package org.perscholas.casestudy.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    private List<OrderDetail> orderDetails;


    @Column(name = "productname")
    private String productName;

    @Column(name = "productdescription")
    private String productDescription;

    @Column(name = "price")
    private Double price;

    @Column(name = "imageurl")
    private String imageUrl;

}
