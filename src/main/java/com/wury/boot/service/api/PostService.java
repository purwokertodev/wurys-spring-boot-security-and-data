package com.wury.boot.service.api;

import com.wury.boot.form.PostForm;
import com.wury.boot.model.PostModel;
import com.wury.boot.model.UserBlogModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by WURI on 06/04/2016.
 */
public interface PostService {

    PostModel create(PostForm postModel, UserBlogModel author);
    Boolean delete(PostModel model, UserBlogModel author);
    Optional<PostModel> findOne(UUID id);
    List<PostModel> findAll();
    Page<PostModel> findAll(Integer pageNumber);
    Page<PostModel> findAll(Integer pageNumber, UserBlogModel author);

}
