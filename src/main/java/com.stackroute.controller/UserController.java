package com.stackroute.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    User user = new User();

    @RequestMapping(value = "/")
    public String greeting(ModelMap map){
        map.addAttribute("greeting","welcome to stackroute!!"+user.getUsername());
        return "index";

    }

    @RequestMapping("/add")
    public ModelAndView login(@RequestParam("t1")String userName,@RequestParam("t2")String password){
        user.setUsername(userName);
        user.setPassword(password);

        String message = "Welcome to Stackroute" + " "+user.getUsername();

        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("login");
        modelView.addObject("result",message);
        return modelView;

    }

}






