package org.perscholas.casestudy.database.dao;

import org.junit.jupiter.api.*;
import org.perscholas.casestudy.database.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    @Test
    @Order(1)
    public void createProductTest(){
        //given
        Product product = new Product();
        product.setProductName("Test Product 12345");
        product.setProductDescription("Test ProductDescription");
        product.setImageUrl("Test Image");
        product.setPrice(10.0);

        //when
        product = productDAO.save(product);

        //then

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals("Test Product 12345", product.getProductName());
        Assertions.assertEquals("Test ProductDescription", product.getProductDescription());
        Assertions.assertEquals("Test Image", product.getImageUrl());
        Assertions.assertEquals(10.0, product.getPrice());
    }
    @Test
    @Order(2)
    public void findByProductNameTest(){
        //given
        String productName = "Test Product 12345";

        //when
        List<Product> products = productDAO.findByProductName(productName);

        //then
        Assertions.assertEquals(1, products.size());

        Product product = products.get(0);
        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals("Test Product 12345", product.getProductName());
        Assertions.assertEquals("Test ProductDescription", product.getProductDescription());
        Assertions.assertEquals("Test Image", product.getImageUrl());
        Assertions.assertEquals(10.0, product.getPrice());

    }
    @Test
    @Order(3)
    public void deleteProductTest(){
        //given
        String productName = "Test Product 12345";

        //when
        int deleted = productDAO.deleteByProductName(productName);

        //then
        Assertions.assertEquals(1, deleted);

    }

}
