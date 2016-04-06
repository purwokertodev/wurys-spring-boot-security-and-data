package com.wury.boot.repository;

import com.wury.boot.model.UserBlogModel;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by WURI on 16/03/2016.
 */
public interface UserBlogRepository extends MyGenericRepository<UserBlogModel, UUID> {

    public Optional<UserBlogModel> findByEmail(String email);
}
