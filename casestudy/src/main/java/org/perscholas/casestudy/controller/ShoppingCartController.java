package org.perscholas.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.CartItemDAO;
import org.perscholas.casestudy.database.dao.OrderDAO;
import org.perscholas.casestudy.database.dao.OrderDetailDAO;
import org.perscholas.casestudy.database.dao.ProductDAO;
import org.perscholas.casestudy.database.entity.CartItem;
import org.perscholas.casestudy.database.entity.Order;
import org.perscholas.casestudy.database.entity.OrderDetail;
import org.perscholas.casestudy.database.entity.User;
import org.perscholas.casestudy.database.service.ShoppingCartServices;
import org.perscholas.casestudy.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class ShoppingCartController {
    @Autowired
    private ProductDAO productDao;

    @Autowired
    private CartItemDAO cartItemDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Autowired
    private ShoppingCartServices shoppingCartServices;

    @GetMapping("/cart/shopping_cart")
    public ModelAndView shopping_cart() {
        ModelAndView response = new ModelAndView("cart/shopping_cart");
        User user = authenticatedUserService.loadCurrentUser();
        List<CartItem> cartItems = shoppingCartServices.listCartItems(user);
        response.addObject("cartItems", cartItems);
        response.addObject("pageTitle", "Shopping Cart");

        return response;

    }

    @GetMapping("/cart/checkout")
    public ModelAndView checkout(){
        ModelAndView response = new ModelAndView("cart/checkout");
        User user = authenticatedUserService.loadCurrentUser();
        List<CartItem> cartItems = shoppingCartServices.listCartItems(user);
        Double totalPrice = 0.0;
        for (CartItem cartItem: cartItems) {
            totalPrice += cartItem.getQuantity() * cartItem.getProduct().getPrice();
        }
        response.addObject("totalPrice", totalPrice);
        response.addObject("cartItems", cartItems);
        response.addObject("pageTitle", "Checkout");
        return response;
    }

    @GetMapping("/cart/place_order")
    public ModelAndView placeOrder(){
        ModelAndView response = new ModelAndView("cart/place_order");
        User user = authenticatedUserService.loadCurrentUser();
        List<CartItem> cartItems = shoppingCartServices.listCartItems(user);

        if(cartItems.isEmpty()) {
            return response;
        }

        Order order = new Order();
        order.setOrderDate(new Date());
        order.setStatus("Order Placed");
        order.setUserId(user.getId());
        orderDAO.save(order);

        response.addObject("order", order);
       for (CartItem cartItem: cartItems) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(cartItem.getProduct());
            orderDetail.setQuantityOrdered(cartItem.getQuantity());
            orderDetail.setPriceEach(cartItem.getProduct().getPrice());
           orderDetailDAO.save(orderDetail);
        }

        response.addObject("orderedItems", cartItems);

       for (CartItem cartItem: cartItems) {
           cartItemDAO.delete(cartItem);
       }

        return response;
    }

    @GetMapping("/order/details")
    public ModelAndView orders(){
        ModelAndView response = new ModelAndView("order/details");
        User user = authenticatedUserService.loadCurrentUser();

        Order order = orderDAO.findLatestOrderByUserId(user.getId());

        List<OrderDetail> orderDetails = orderDetailDAO.findByOrder(order);

        response.addObject("order", order);
        response.addObject("orderDetails", orderDetails);

        return response;
    }

}


