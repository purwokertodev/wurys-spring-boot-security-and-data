package com.wury.boot.repository;

import com.wury.boot.model.PostModel;
import com.wury.boot.model.UserBlogModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

/**
 * Created by WURI on 06/04/2016.
 */
public interface PostRepostory extends MyGenericRepository<PostModel, UUID> {

    Page<PostModel> findByUserBlogModel(UserBlogModel author, Pageable pageable);
    
}
