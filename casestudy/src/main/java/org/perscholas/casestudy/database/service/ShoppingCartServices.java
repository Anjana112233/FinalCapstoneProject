package org.perscholas.casestudy.database.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.CartItemDAO;
import org.perscholas.casestudy.database.entity.CartItem;
import org.perscholas.casestudy.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ShoppingCartServices {
    @Autowired
    private CartItemDAO cartItemDAO;
    public List<CartItem> listCartItems(User user) {

        return cartItemDAO.findByUser(user);
    }

}
