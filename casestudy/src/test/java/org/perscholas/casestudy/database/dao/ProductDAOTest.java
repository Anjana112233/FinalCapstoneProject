package org.perscholas.casestudy.database.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.perscholas.casestudy.database.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    @Test
    public void createProductTest(){
        //given
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductDescription("Test ProductDescription");
        product.setImageUrl("Test Image");
        product.setPrice(10.0);

        //when
        product = productDAO.save(product);

        //then

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals("Test Product", product.getProductName());
        Assertions.assertEquals("Test ProductDescription", product.getProductDescription());
        Assertions.assertEquals("Test Image", product.getImageUrl());
        Assertions.assertEquals(10.0, product.getPrice());
    }
}
