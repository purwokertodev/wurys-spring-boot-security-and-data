package com.wury.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by WURI on 03/04/2016.
 */
@Controller
@RequestMapping(value = "/author/")
public class DashboardController {

    @RequestMapping(value = "/dashboard")
    public ModelAndView dashboard(){
        ModelAndView mav = new ModelAndView("author/dashboard");
        return mav;
    }
}
