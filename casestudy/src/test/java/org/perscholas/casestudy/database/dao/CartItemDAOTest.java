package org.perscholas.casestudy.database.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.perscholas.casestudy.database.entity.CartItem;
import org.perscholas.casestudy.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartItemDAOTest {
    @Autowired
    private CartItemDAO cartItemDAO;

    @Test

    public void createCartItemTest() {
        User user = new User();
        user.setId(8);

        List<CartItem> cartItems = cartItemDAO.findByUser(user);
       Assertions.assertEquals(0, cartItems.size());

    }

}
