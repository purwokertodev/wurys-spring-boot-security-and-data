package com.wury.boot.service.api;

import com.wury.boot.form.CommentForm;
import com.wury.boot.model.CommentModel;
import com.wury.boot.model.PostModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by WURI on 06/04/2016.
 */
public interface CommentService {

    CommentModel createComment(CommentForm form);
    Optional<CommentModel> findOne(UUID id);
    List<CommentModel> findByPostModel(PostModel postModel);

}
