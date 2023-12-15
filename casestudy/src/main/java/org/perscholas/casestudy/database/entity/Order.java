package org.perscholas.casestudy.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userid")
    private Integer userId;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;


    @Column(name = "orderdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "requireddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requiredDate;

    @Column(name = "shippeddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippedDate;

    @Column(name = "status")
    private String status;







}
