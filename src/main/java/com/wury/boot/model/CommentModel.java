package com.wury.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by WURI on 06/04/2016.
 */
@Entity
@Table(name = "comment")
public class CommentModel extends AbstractMyModel {

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private PostModel postModel;

    @Column(name = "commentator_name", nullable = false)
    private String commentatorName;

    @Column(name = "comment_content", nullable = false)
    private String commentContent;

    public PostModel getPostModel() {
        return postModel;
    }

    public void setPostModel(PostModel postModel) {
        this.postModel = postModel;
    }

    public String getCommentatorName() {
        return commentatorName;
    }

    public void setCommentatorName(String commentatorName) {
        this.commentatorName = commentatorName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
