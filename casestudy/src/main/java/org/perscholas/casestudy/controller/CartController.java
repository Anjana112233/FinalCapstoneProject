package org.perscholas.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.ProductDAO;
import org.perscholas.casestudy.database.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class CartController {
    @Autowired
    private ProductDAO productDao;

    @RequestMapping("/cart/additem")
    public ModelAndView additem(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("cart/additem");

        Product product = productDao.findById(id);
        response.addObject("product", product);

        return response;
    }

}
