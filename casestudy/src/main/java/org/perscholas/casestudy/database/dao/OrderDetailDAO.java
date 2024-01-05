package org.perscholas.casestudy.database.dao;

import org.perscholas.casestudy.database.entity.Order;
import org.perscholas.casestudy.database.entity.OrderDetail;
import org.perscholas.casestudy.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

    public OrderDetail findById(Integer id);
    @Query("SELECT od FROM OrderDetail od WHERE od.order.id = :orderId AND od.product.id = :productId")
   OrderDetail findByOrderIdAndProductId(Integer orderId, Integer productId);

    @Query("Select OrderDetail.id, productname , quantityordered, price, price*quantityordered as producttotal " +
            "from OrderDetail inner join Product on OrderDetail.productid = Product.productid" +
            "where orderId = :orderId  ")
    static OrderDetail viewcart(Integer orderId) {
        return null;
    }

    @Query("Select sum(price*quantityordered) from OrderDetail inner join Product on OrderDetail.productid = Product.productid " +
            "where orderId = :orderId ")
    static OrderDetail carttotal(Integer orderId) {
        return null;
    }


}
