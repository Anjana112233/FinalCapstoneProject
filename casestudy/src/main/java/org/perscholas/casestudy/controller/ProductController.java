package org.perscholas.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.ProductDAO;
import org.perscholas.casestudy.database.entity.Product;
import org.perscholas.casestudy.formbean.CreateProductFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

        //if the form id is null then this is a create, if it is not null then it is an edit
        //first we attempt to load it from the database
        //if it is found in the database we know the incoming id was valid so we can edit it
        Product product = productDao.findById(form.getId());
        if (product == null){
            product = new Product();

        }
       // Product product = new Product();
        product.setProductName(form.getProductName());
        product.setProductDescription(form.getProductDescription());
        product.setImageUrl(form.getImageUrl());
        product.setPrice(form.getPrice());

        productDao.save(product);

        log.debug("In create product with incoming args");

        return response;

    }

    @GetMapping("/product/search")
    public ModelAndView search(@RequestParam(required = false) String productNameSearch) {
        ModelAndView response = new ModelAndView("product/search");

        log.debug("In the product search container method: search parameter = " + productNameSearch);

        if(productNameSearch != null){

           // response.addObject("productsVar", products);
            response.addObject("productNamesearch", productNameSearch);

           if (!StringUtils.isEmpty(productNameSearch)) {
               productNameSearch = "%" + productNameSearch + "%";
            }
            List<Product> products = productDao.findByProductName(productNameSearch);
            response.addObject("productsVar", products);

            for (Product product : products) {
                log.debug("product: id "+product.getId()+" Product Name "+product.getProductName()+" Product Description "+product.getProductDescription());
                log.debug("product: image Url "+product.getImageUrl()+" price "+product.getPrice());
            }

        } else {
            List<Product> products = productDao.findAll().subList(0, 3);
            response.addObject("productsVar", products);
        }

        return response;
    }
    @GetMapping("/product/edit/{productId}")
    public ModelAndView editProduct(@PathVariable int productId, @RequestParam(required = false) String success) {
        log.info("######################### In /product/edit #########################");
        ModelAndView response = new ModelAndView("product/create");
        Product product = productDao.findById(productId);

        if (!StringUtils.isEmpty(success)) {
            response.addObject("success", success);
        }

        CreateProductFormBean form = new CreateProductFormBean();

        if (product != null){
            form.setId(product.getId());
            form.setProductName(product.getProductName());
            form.setProductDescription(product.getProductDescription());
            form.setImageUrl(product.getImageUrl());
            form.setPrice(product.getPrice());
        } else{
            log.warn("Product with id" + "was not found");
        }
        response.addObject("form", form);
        return response;
    }
    @RequestMapping("/product/detail")
    public ModelAndView detail(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("product/detail");

        Product product = productDao.findById(id);

        if ( product == null ) {
            log.warn("Product with id " + id + " was not found");
            // in a real application you might redirect to a 404 here because the product was not found
            response.setViewName("redirect:/error/404");
            return response;
        }

        response.addObject("product", product);

        return response;
    }

}

