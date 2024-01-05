package org.perscholas.casestudy.database.dao;

import org.perscholas.casestudy.database.entity.Order;

import org.perscholas.casestudy.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

  public Order findById(Integer id);
  @Query("Select o from Order o where o.userId = :userId AND o.status = 'cart' ")
 Order findCartOrdersByUserId(Integer userId);

}
