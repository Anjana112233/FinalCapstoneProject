package org.perscholas.casestudy.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

   // @Column(name = "orderid")
  // private Integer orderId;
   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "orderid", nullable = false)
   private Order order;

    @Column(name = "productid")
    private Integer productId;

    @Column(name = "quantityordered")
    private Integer quantityOrdered;

    @Column(name = "priceeach")
    private Double priceEach;
}
