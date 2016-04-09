package com.wury.boot.service.api;

import com.wury.boot.form.UserBlogForm;
import com.wury.boot.model.UserBlogModel;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by WURI on 04/04/2016.
 */
public interface UserBlogService {

    UserBlogModel create(UserBlogForm form);
    Optional<UserBlogModel> findOne(UUID id);
    Optional<UserBlogModel> findByEmail(String email);
    Collection<UserBlogModel> findAll();
}
