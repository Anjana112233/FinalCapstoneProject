package org.perscholas.casestudy.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.entity.User;
import org.perscholas.casestudy.database.service.UserService;
import org.perscholas.casestudy.formbean.RegisterUserFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller

public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/auth/login1")
    public ModelAndView login() {
        ModelAndView response = new ModelAndView();
        response.setViewName("auth/login1");
        return response;
    }
    @GetMapping("/auth/register1")
    public ModelAndView register() {
        ModelAndView response = new ModelAndView();
        response.setViewName("auth/register1");
        return response;
    }

    @GetMapping("/auth/register1Submit")
    public ModelAndView registerSubmit(@Valid RegisterUserFormBean form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("######################### In register user - has errors #########################");
            ModelAndView response = new ModelAndView("auth/register1");

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("######################### In register user - no error found #########################");

        User u = userService.createNewUser(form);

        // the view name can either be a jsp file name or a redirect to another controller method
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/");

        return response;
    }




}
