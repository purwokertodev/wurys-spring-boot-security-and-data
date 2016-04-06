package com.wury.boot.service.impl;

import com.wury.boot.model.UserBlogModel;
import com.wury.boot.repository.UserBlogRepository;
import com.wury.boot.service.api.UserBlogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by WURI on 04/04/2016.
 */
@Service
@Transactional(readOnly = false)
public class UserBlogServiceImpl implements UserBlogService {

    private static final Logger LOGGER = Logger.getLogger(UserBlogServiceImpl.class);

    @Autowired
    private UserBlogRepository userBlogRepository;

    @Override
    public UserBlogModel create(UserBlogModel m) {
        return userBlogRepository.save(m);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserBlogModel> findOne(UUID id) {
        LOGGER.debug("Find One "+ id);
        return Optional.ofNullable(userBlogRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserBlogModel> findOneByEmail(String email) {
        return userBlogRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<UserBlogModel> findAll() {
        return userBlogRepository.findAll(new Sort("name"));
    }
}
