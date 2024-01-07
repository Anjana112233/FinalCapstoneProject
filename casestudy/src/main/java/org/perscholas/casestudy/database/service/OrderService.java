package org.perscholas.casestudy.database.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.OrderDAO;
import org.perscholas.casestudy.database.entity.Order;
import org.perscholas.casestudy.database.entity.User;
import org.perscholas.casestudy.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    public Order createNewOrder(){
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setStatus("Cart");
        return orderDAO.save(order);
    }

}
