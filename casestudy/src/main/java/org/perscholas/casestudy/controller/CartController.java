package org.perscholas.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.OrderDAO;
import org.perscholas.casestudy.database.dao.ProductDAO;
import org.perscholas.casestudy.database.entity.Order;
import org.perscholas.casestudy.database.entity.OrderDetail;
import org.perscholas.casestudy.database.entity.Product;
import org.perscholas.casestudy.database.entity.User;
import org.perscholas.casestudy.formbean.CreateOrderFormBean;
import org.perscholas.casestudy.formbean.CreateProductFormBean;
import org.perscholas.casestudy.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Slf4j
@Controller
public class CartController {
    @Autowired
    private ProductDAO productDao;

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/order/create")
    public ModelAndView createOrder() {
        ModelAndView response = new ModelAndView("order/create");

        log.debug("In create order with no args");

        return response;
    }
    @GetMapping("/order/createSubmit")
    public ModelAndView createOrderSubmit(CreateOrderFormBean form){
        ModelAndView response = new ModelAndView("order/create");

        System.out.println("orderDate: "+ form.getOrderdate());
        System.out.println("requiredDate: "+ form.getRequireddate());
        System.out.println("shippedDate: "+ form.getShippeddate());
        System.out.println("status: "+ form.getStatus());


        Order order = new Order();
        order.setOrderDate(form.getOrderdate());
        order.setRequiredDate(form.getRequireddate());
        order.setShippedDate(form.getShippeddate());
        order.setStatus(form.getStatus());

        orderDao.save(order);

        log.debug("In create order with incoming args");

        return response;

    }
    @RequestMapping("/cart/additem")
    public ModelAndView additem(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("cart/additem");

        // Product product = productDao.findById(id);
        //   response.addObject("product", product);

        User user = authenticatedUserService.loadCurrentUser();
        Order order = orderDao.findCartOrdersByUserId(user.getId());

        //things to do
        OrderDetail orderDetail = new OrderDetail();
       // orderDetail.setProductId(form.getproductid);
       // orderdetail.setuserId(form.getuserId);
       // orderDetail.setQuantityOrdered(form.getquantityordered);
       // orderDetail.getPriceEach(form.getPriceeach);
        if (order == null) {
            order = new Order();


            order.setUserId(user.getId());
        }
        order.setOrderDate(new Date());
       // order.setRequiredDate(order.getRequiredDate());
       // order.setShippedDate(order.getShippedDate());
        order.setStatus("cart");
        orderDao.save(order);

            return response;
        }

    }
