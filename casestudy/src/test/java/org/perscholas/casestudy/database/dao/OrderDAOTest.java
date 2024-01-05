package org.perscholas.casestudy.database.dao;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderDAOTest {

    @Autowired
    private OrderDAO orderDAO;

    @Test
    @Order(1)

    public void createOrderTest(){


    }

}