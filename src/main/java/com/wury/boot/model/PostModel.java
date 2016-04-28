package com.wury.boot.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by WURI on 06/04/2016.
 */
@Entity
@Table(name = "post")
public class PostModel extends AbstractMyModel {

    @ManyToOne
    @JoinColumn(name = "user_blog_id")
    private UserBlogModel userBlogModel;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_content", nullable = false)
    private String postContent;

    @OneToMany(mappedBy = "postModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CommentModel> comments;

    public UserBlogModel getUserBlogModel() {
        return userBlogModel;
    }

    public void setUserBlogModel(UserBlogModel userBlogModel) {
        this.userBlogModel = userBlogModel;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }
}
