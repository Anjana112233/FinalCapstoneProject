package org.perscholas.casestudy.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.CartItemDAO;
import org.perscholas.casestudy.database.dao.OrderDAO;
import org.perscholas.casestudy.database.dao.OrderDetailDAO;
import org.perscholas.casestudy.database.dao.ProductDAO;
import org.perscholas.casestudy.database.entity.*;
import org.perscholas.casestudy.database.service.OrderDetailService;
import org.perscholas.casestudy.database.service.OrderService;
import org.perscholas.casestudy.formbean.CreateOrderDetailFormBean;
import org.perscholas.casestudy.formbean.CreateOrderFormBean;
import org.perscholas.casestudy.formbean.CreateProductFormBean;
import org.perscholas.casestudy.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class CartController {
    @Autowired
    private ProductDAO productDao;

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private CartItemDAO cartItemDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/order/create")
    public ModelAndView createOrder() {
        ModelAndView response = new ModelAndView("order/create");

        log.debug("In create order with no args");

        return response;
    }

    @GetMapping("/order/createSubmit")
    public ModelAndView createOrderSubmit(CreateOrderFormBean form) {
        ModelAndView response = new ModelAndView("order/create");

        System.out.println("orderDate: " + form.getOrderdate());
        System.out.println("requiredDate: " + form.getRequireddate());
        System.out.println("shippedDate: " + form.getShippeddate());
        System.out.println("status: " + form.getStatus());


        Order order = new Order();
        order.setOrderDate(form.getOrderdate());
        order.setRequiredDate(form.getRequireddate());
        order.setShippedDate(form.getShippeddate());
        order.setStatus(form.getStatus());

        orderDao.save(order);

        log.debug("In create order with incoming args");

        return response;
    }
    @RequestMapping("/cart/addtocart")
    public ModelAndView additem(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("cart/addtocart");

        log.info("In add item with incoming args");
        Product product = productDao.findById(id);
        log.info("In add item with product incoming args");
        response.addObject("product", product);

        User user = authenticatedUserService.loadCurrentUser();

        CartItem cartItem = cartItemDAO.findByUserAndProduct(user, product);

//add product to add to cart
        if (cartItem == null) {
            CartItem cartItemNew = new CartItem();
            cartItemNew.setUser(user);
            cartItemNew.setProduct(product);
            cartItemNew.setQuantity(1);
            cartItemDAO.save(cartItemNew);
        } else {
            Integer quantity = cartItem.getQuantity();
            cartItem.setQuantity(quantity + 1);
            cartItemDAO.save(cartItem);
        }
        response.addObject("product", product);
        return response;

    }
}


