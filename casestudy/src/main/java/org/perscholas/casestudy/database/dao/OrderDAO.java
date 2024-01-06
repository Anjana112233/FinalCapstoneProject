package org.perscholas.casestudy.database.dao;

import org.perscholas.casestudy.database.entity.Order;

import org.perscholas.casestudy.database.entity.Product;
import org.perscholas.casestudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

  public Order findById(Integer id);

  @Query("Select o from Order o where o.userId = :userId order by orderDate desc limit 1 ")
 Order findLatestOrderByUserId(Integer userId);

}
