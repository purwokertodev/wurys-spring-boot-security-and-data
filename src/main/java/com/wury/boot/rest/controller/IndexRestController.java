package com.wury.boot.rest.controller;

import com.wury.boot.model.PostModel;
import com.wury.boot.service.api.PostService;
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
@RequestMapping(value = "/rest/public/post/")
public class IndexRestController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<PostModel> getPosts(){
        return postService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PostModel getPost(@PathVariable("id")UUID id){
        return postService.findOne(id).get();
    }
}
