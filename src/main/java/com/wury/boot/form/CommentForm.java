package com.wury.boot.form;

import com.wury.boot.model.PostModel;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by WURI on 26/04/2016.
 */
public class CommentForm {

    private PostModel postModel;
    @NotEmpty
    private String commentatorName = "";
    @NotEmpty
    private String commentContent = "";

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
