package com.wury.boot.service.impl;

import com.wury.boot.form.CommentForm;
import com.wury.boot.model.CommentModel;
import com.wury.boot.model.PostModel;
import com.wury.boot.model.UserBlogModel;
import com.wury.boot.repository.CommentRepository;
import com.wury.boot.service.api.CommentService;
import com.wury.boot.service.api.PostService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by WURI on 06/04/2016.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    private static final Logger LOGGER = Logger.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostService postService;

    @Override
    public CommentModel createComment(CommentForm form) {
        LOGGER.debug("SAVE COMMENT");
        CommentModel model = new CommentModel();
        model.setPostModel(postService.findOne(form.getPostModel()).get());
        model.setCommentatorName(form.getCommentatorName());
        model.setCommentContent(form.getCommentContent());
        model.setCreatedAt(new Date());
        model.setCreatedById(UUID.randomUUID());
        model.setUpdatedAt(new Date());
        model.setUpdatedById(UUID.randomUUID());
        commentRepository.save(model);
        return model;
    }

    @Override
    public Boolean delete(CommentModel model, UserBlogModel postAuthor) {
        LOGGER.debug("REMOVE COMMENT = "+model.getId());
        return commentRepository.delete(model, postAuthor);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CommentModel> findOne(UUID id) {
        LOGGER.debug("FIND COMMENT ONE = "+id);
        return Optional.ofNullable(commentRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommentModel> findByPostModel(PostModel postModel) {
        return commentRepository.findByPostModelAndDeletedAtIsNullOrderByCreatedAtDesc(postModel);
    }
}
