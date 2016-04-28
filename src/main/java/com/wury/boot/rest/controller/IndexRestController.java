package com.wury.boot.rest.controller;

import com.wury.boot.model.PostModel;
import com.wury.boot.model.UserBlogModel;
import com.wury.boot.service.api.PostService;
import com.wury.boot.service.api.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * Created by WURI on 26/04/2016.
 */
@Controller
@RequestMapping(value = "/rest/public/")
public class IndexRestController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserBlogService userBlogService;

    @RequestMapping(value = "/post/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<PostModel> getPosts(){
        return postService.findAll();
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public PostModel getPost(@PathVariable("id")UUID id){
        return postService.findOne(id).get();
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserBlogModel getUserBlogProfile(@PathVariable("id") UUID id){
        return userBlogService.findOne(id).get();
    }


}
