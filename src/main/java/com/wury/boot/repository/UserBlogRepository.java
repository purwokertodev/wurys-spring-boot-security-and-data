package com.wury.boot.repository;

import com.wury.boot.model.UserBlog;

import java.util.UUID;

/**
 * Created by WURI on 16/03/2016.
 */
public interface UserBlogRepository extends MyGenericRepository<UserBlog, UUID> {

    public UserBlog findByEmail(String email);
}
