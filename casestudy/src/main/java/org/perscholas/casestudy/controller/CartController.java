package org.perscholas.casestudy.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.OrderDAO;
import org.perscholas.casestudy.database.dao.OrderDetailDAO;
import org.perscholas.casestudy.database.dao.ProductDAO;
import org.perscholas.casestudy.database.entity.Order;
import org.perscholas.casestudy.database.entity.OrderDetail;
import org.perscholas.casestudy.database.entity.Product;
import org.perscholas.casestudy.database.entity.User;
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
        Order order = orderDao.findCartOrdersByUserId(user.getId());


        if (order == null) {
            order = new Order();

            order.setUserId(user.getId());


            order.setOrderDate(new Date());
            // order.setRequiredDate(order.getRequiredDate());
            // order.setShippedDate(order.getShippedDate());
            order.setStatus("cart");
            orderDao.save(order);
        }
       orderDetailService.createOrderDetail(product.getId(), order.getId(), 1);
        //response.addObject("order", order);
      //  response.addObject("product", product);
        return response;

    }
    @RequestMapping("cart/viewcart")
    public ModelAndView viewcart() {
        ModelAndView response = new ModelAndView("cart/viewcart");
        User user = authenticatedUserService.loadCurrentUser();
        //retrieve a current cart
        Order order= orderDao.findCartOrdersByUserId(user.getId());

       if(order == null){
            response.setViewName("redirect:/product/search/");
            return response;
        }
        OrderDetail orderDetail = orderDetailDAO.viewcart(order.getId());
        OrderDetail orderDetail1 = orderDetailDAO.carttotal(order.getId());
        response.addObject("order", order);
        response.addObject("orderdetail", orderDetail);
        response.addObject("orderdetail1", orderDetail1);

        return response;

    }
}


