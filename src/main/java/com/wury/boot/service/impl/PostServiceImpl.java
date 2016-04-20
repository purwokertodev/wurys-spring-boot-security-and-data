package com.wury.boot.service.impl;

import com.wury.boot.form.PostForm;
import com.wury.boot.model.PostModel;
import com.wury.boot.model.UserBlogModel;
import com.wury.boot.repository.PostRepository;
import com.wury.boot.service.api.PostService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by WURI on 06/04/2016.
 */
@Transactional
@Service
public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = Logger.getLogger(PostServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostModel create(PostForm form, UserBlogModel author) {
        LOGGER.debug("Create Post by "+author.getEmail());
        PostModel postModel = new PostModel();
        postModel.setUserBlogModel(author);
        postModel.setPostTitle(form.getPostTitle());
        postModel.setPostContent(form.getPostContent());
        return postRepository.save(postModel, author);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PostModel> findOne(UUID id) {
        LOGGER.debug("FIND ONE"+id);
        return Optional.ofNullable(postRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostModel> findAll() {
        LOGGER.debug("FIND ALL WITH COLLECTION");
        return postRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PostModel> findAll(Integer pageNumber) {
        LOGGER.debug("FIND ALL");
        return postRepository.findAll(createPageRequest(pageNumber));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PostModel> findAll(Integer pageNumber, UserBlogModel author) {
        LOGGER.debug("FIND ALL BY AUTHOR"+author.getEmail());
        return postRepository.findByUserBlogModel(author, createPageRequest(pageNumber));
    }

    private Pageable createPageRequest(Integer pageNumber){
        PageRequest request = new PageRequest(pageNumber - 1, 50, Sort.Direction.ASC, "createdAt");
        return request;
    }
}
