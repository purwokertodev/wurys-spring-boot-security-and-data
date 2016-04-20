package com.wury.boot.controller;

import com.wury.boot.model.CurrentUser;
import com.wury.boot.model.UserBlogModel;
import com.wury.boot.service.api.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by WURI on 03/04/2016.
 */
@Controller
@RequestMapping(value = "/author/")
public class DashboardController {

    @Autowired
    private UserBlogService userBlogService;

    @RequestMapping(value = "/dashboard")
    public ModelAndView dashboard(Authentication authentication){
        CurrentUser currentUser = new CurrentUser(authentication, userBlogService);
        ModelAndView mav = new ModelAndView("author/dashboard");
        mav.addObject("current_author", currentUser.getUserNameNow());
        return mav;
    }
}
