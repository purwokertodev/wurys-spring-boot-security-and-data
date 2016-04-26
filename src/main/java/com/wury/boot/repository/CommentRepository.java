package com.wury.boot.repository;

import com.wury.boot.model.CommentModel;
import com.wury.boot.model.PostModel;

import java.util.List;
import java.util.UUID;

/**
 * Created by WURI on 06/04/2016.
 */
public interface CommentRepository extends MyGenericRepository<CommentModel, UUID> {

    List<CommentModel> findByPostModelOrderByCreatedAtDesc(PostModel postModel);

}
