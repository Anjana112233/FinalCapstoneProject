package org.perscholas.casestudy.database.dao;

import org.perscholas.casestudy.database.entity.CartItem;
import org.perscholas.casestudy.database.entity.Product;
import org.perscholas.casestudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemDAO extends JpaRepository<CartItem, Long> {
    public List<CartItem> findByUser(User user);

    public CartItem findByUserAndProduct(User user, Product product);


}
