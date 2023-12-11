package org.perscholas.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.ProductDAO;
import org.perscholas.casestudy.database.entity.Product;
import org.perscholas.casestudy.formbean.CreateProductFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller

public class ProductController {

    @Autowired
    private ProductDAO productDao;

    @GetMapping("/product/create")
    public ModelAndView createProduct() {
        ModelAndView response = new ModelAndView("product/create");

       log.debug("In create customer with no args");

        return response;
    }

    @GetMapping("/product/createSubmit")
    public ModelAndView createProductSubmit(CreateProductFormBean form){
        ModelAndView response = new ModelAndView("product/create");

        System.out.println("productName: "+ form.getProductName());
        System.out.println("productDescription: "+ form.getProductDescription());
        System.out.println("imageUrl: "+ form.getImageUrl());
        System.out.println("price: "+ form.getPrice());


        Product product = new Product();
        product.setProductName(form.getProductName());
        product.setProductDescription(form.getProductDescription());
        product.setImageUrl(form.getImageUrl());
        product.setPrice(form.getPrice());

        productDao.save(product);

        log.debug("In create product with incoming args");

        return response;

    }



}
