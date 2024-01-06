package org.perscholas.casestudy.database.dao;

import jakarta.transaction.Transactional;
import org.perscholas.casestudy.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
    public Product findById(Integer id);

    @Query("Select p from Product p where lower(p.productName) LIKE lower(%:productName%)")
    List<Product> findByProductName(String productName);



    //for testing
    @Modifying
    @Transactional
    int deleteByProductName(String productName);




}
