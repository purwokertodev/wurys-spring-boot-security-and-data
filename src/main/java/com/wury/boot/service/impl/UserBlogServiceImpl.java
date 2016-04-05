package com.wury.boot.service.impl;

import com.wury.boot.model.UserBlog;
import com.wury.boot.repository.UserBlogRepository;
import com.wury.boot.service.api.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by WURI on 04/04/2016.
 */
@Service
@Transactional(readOnly = false)
public class UserBlogServiceImpl implements UserBlogService {

    @Autowired
    private UserBlogRepository userBlogRepository;

    @Override
    public UserBlog create(UserBlog m) {
        return userBlogRepository.save(m);
    }

    @Override
    @Transactional(readOnly = true)
    public UserBlog findOne(UUID id) {
        return userBlogRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserBlog findOneByEmail(String email) {
        return userBlogRepository.findByEmail(email);
    }
}
