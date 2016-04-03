package com.wury.boot.repository;

import com.wury.boot.model.UserBlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by WURI on 16/03/2016.
 */
@Repository
public interface UserBlogRepository extends CrudRepository<UserBlog, UUID> {

    public UserBlog findByEmail(String email);
}
