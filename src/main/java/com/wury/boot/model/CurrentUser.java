package com.wury.boot.model;

import com.wury.boot.service.api.UserBlogService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

/**
 * Created by WURI on 19/04/2016.
 */
public class CurrentUser {

    private UserBlogModel userBlogModel;

    public CurrentUser(Authentication authentication, UserBlogService userBlogService) {
        UserDetails user = (UserDetails) authentication.getPrincipal();
        userBlogModel = userBlogService.findByEmail(user.getUsername()).get();
    }

    public UserBlogModel getUserNow(){
        return userBlogModel;
    }

    public String getUserNameNow(){
        return userBlogModel.getName();
    }

    public String getUserEmailNow(){
        return userBlogModel.getEmail();
    }

    public UUID getUserIdNow(){
        return userBlogModel.getId();
    }

    public List<UserBlogRoleModel> getUserRolesNow(){
        return userBlogModel.getUserRoles();
    }

}
