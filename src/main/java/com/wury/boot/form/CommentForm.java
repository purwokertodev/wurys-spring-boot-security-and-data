package com.wury.boot.form;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.UUID;

/**
 * Created by WURI on 26/04/2016.
 */
public class CommentForm {

    private UUID postModel;
    @NotEmpty
    private String commentatorName = "";
    @NotEmpty
    private String commentContent = "";

    public UUID getPostModel() {
        return postModel;
    }

    public void setPostModel(UUID postModel) {
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
