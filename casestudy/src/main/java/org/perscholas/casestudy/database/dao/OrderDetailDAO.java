package org.perscholas.casestudy.database.dao;

import org.perscholas.casestudy.database.entity.Order;
import org.perscholas.casestudy.database.entity.OrderDetail;
import org.perscholas.casestudy.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

    public OrderDetail findById(Integer id);
    @Query("SELECT od FROM OrderDetail od WHERE od.order.id = :orderId AND od.product.id = :productId")
   OrderDetail findByOrderIdAndProductId(Integer orderId, Integer productId);

  /*  @Query("Select OrderDetail.id, productname , quantityordered, price, price*quantityordered as producttotal " +
            "from OrderDetail inner join Product on OrderDetail.productid = Product.productid" +
            "where order.id = :order.id  ")
    public OrderDetail viewcart(Integer orderId);*/

    @Query("SELECT od.id, p.productName, od.quantityOrdered, p.price, p.price * od.quantityOrdered AS productTotal " +
            "FROM OrderDetail od " +
            "INNER JOIN od.product p " +
            "INNER JOIN od.order o " +
            "WHERE o.id = :orderId")
    OrderDetail viewcart(@Param("orderId") Integer orderId);


   /* @Query("Select sum(price*quantityordered) from OrderDetail inner join Product on OrderDetail.productid = Product.productid " +
            "where orderId = :orderId ")*/
   @Query("SELECT sum(p.price * od.quantityOrdered) " +
           "FROM OrderDetail od " +
           "INNER JOIN od.product p " +
           "INNER JOIN od.order o " +
           "WHERE o.id = :orderId")
    public OrderDetail carttotal(Integer orderId);



}
