package com.wury.boot.service.api;

import com.wury.boot.model.UserBlog;

import java.util.UUID;

/**
 * Created by WURI on 04/04/2016.
 */
public interface UserBlogService {

    UserBlog create(UserBlog m);
    UserBlog findOne(UUID id);
    UserBlog findOneByEmail(String email);
}
