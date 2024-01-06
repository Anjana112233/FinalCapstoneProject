package org.perscholas.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.CartItemDAO;
import org.perscholas.casestudy.database.dao.ProductDAO;
import org.perscholas.casestudy.database.entity.CartItem;
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

import java.util.List;

@Slf4j
@Controller
public class ShoppingCartController {
    @Autowired
    private ProductDAO productDao;

    @Autowired
    private CartItemDAO cartItemDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Autowired
    private ShoppingCartServices shoppingCartServices;

    @GetMapping("/cart/shopping_cart")
    public ModelAndView shopping_cart(){
        ModelAndView response = new ModelAndView("cart/shopping_cart");
        User user = authenticatedUserService.loadCurrentUser();
        List<CartItem> cartItems = shoppingCartServices.listCartItems(user);
        response.addObject("cartItems", cartItems);
        response.addObject("pageTitle", "Shopping Cart");

        return response;

  /*  @GetMapping("/cart")
    public String showShoppingCart(Model model){
        User user = authenticatedUserService.loadCurrentUser();
        List<CartItem> cartItems = shoppingCartServices.listCartItems(user);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("pageTitle", "Shopping Cart");

        return "shopping_cart";*/

    }

}
