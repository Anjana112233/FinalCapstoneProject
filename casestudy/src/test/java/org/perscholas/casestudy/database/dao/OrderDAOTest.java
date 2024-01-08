package org.perscholas.casestudy.database.dao;

import org.junit.jupiter.api.*;
import org.perscholas.casestudy.database.entity.Order;
import org.perscholas.casestudy.database.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.perscholas.casestudy.database.entity.Order;
import java.util.Date;
import java.util.logging.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderDAOTest {

    private static Logger logger = Logger.getLogger("org.perscholas.casestudy.database.dao.test");

    @Autowired
    private OrderDAO orderDAO;

    @Test
    public void createOrderTest(){
        //given
        Date date = new Date();
        String orderStatus = "Cart";
        logger.info("Creating a new order");
        Order order = new Order();
        order.setUserId(5);
        order.setOrderDate(date);
        order.setStatus(orderStatus);

        //when
        order = orderDAO.save(order);

        //then

        Assertions.assertNotNull(order.getId());
        logger.info("Verified order id is not null");
        Assertions.assertEquals(date, order.getOrderDate());
        logger.info("Verified database date matches order date");
        Assertions.assertEquals(orderStatus, order.getStatus());
        logger.info("Verified database order status matches given order status");
    }


    }


