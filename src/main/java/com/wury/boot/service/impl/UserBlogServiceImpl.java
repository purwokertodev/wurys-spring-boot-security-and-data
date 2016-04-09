package com.wury.boot.service.impl;

import com.wury.boot.form.UserBlogForm;
import com.wury.boot.model.UserBlogModel;
import com.wury.boot.repository.UserBlogRepository;
import com.wury.boot.service.api.UserBlogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
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
    public UserBlogModel create(UserBlogForm form) {
        UserBlogModel u = new UserBlogModel();
        u.setName(form.getName());
        u.setEmail(form.getEmail());
        u.setWebsite(form.getWebsite());
        u.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        u.setPictureLocation(form.getPictureLocation());
        u.setUserRoles(form.getUserRoles());
        u.setCreatedAt(new Date());
        u.setCreatedById(UUID.randomUUID());
        u.setUpdatedAt(new Date());
        u.setUpdatedById(UUID.randomUUID());
        return userBlogRepository.save(u);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserBlogModel> findOne(UUID id) {
        LOGGER.debug("Find One "+ id);
        return Optional.ofNullable(userBlogRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserBlogModel> findByEmail(String email) {
        return userBlogRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<UserBlogModel> findAll() {
        return userBlogRepository.findAll(new Sort("name"));
    }
}
