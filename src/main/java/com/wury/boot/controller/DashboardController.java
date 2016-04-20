package com.wury.boot.controller;

import com.wury.boot.form.PostForm;
import com.wury.boot.model.CurrentUser;
import com.wury.boot.model.UserBlogModel;
import com.wury.boot.service.api.PostService;
import com.wury.boot.service.api.UserBlogService;
import com.wury.boot.validator.PostFormValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by WURI on 03/04/2016.
 */
@Controller
@RequestMapping(value = "/author/")
public class DashboardController {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class);

    @Autowired
    private UserBlogService userBlogService;
    @Autowired
    private PostService postService;
    @Autowired
    private PostFormValidator postFormValidator;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard(Authentication authentication){
        CurrentUser currentUser = new CurrentUser(authentication, userBlogService);
        ModelAndView mav = new ModelAndView("author/dashboard");
        mav.addObject("current_author", currentUser.getUserNameNow());
        return mav;
    }

    @RequestMapping(value = "/new_post", method = RequestMethod.GET)
    public String newPost(@ModelAttribute PostForm postForm, Model model){
        LOGGER.debug("PREPARE NEW POST");
        model.addAttribute("postForm", postForm);
        return "author/new_post";
    }

    @RequestMapping(value = "/new_post", method = RequestMethod.POST)
    public String newPostFinish(@Valid @ModelAttribute("postForm") PostForm form,
                                BindingResult result, RedirectAttributes redirectAttributes, Authentication authentication){
        LOGGER.debug("NEW POST FINISH");

        postFormValidator.validate(form, result);
        if(result.hasErrors()){
            return "author/new_post";
        }
        CurrentUser currentUser = new CurrentUser(authentication, userBlogService);
        postService.create(form, currentUser.getUserNow());
        return "redirect:/author/new_post";
    }
}
