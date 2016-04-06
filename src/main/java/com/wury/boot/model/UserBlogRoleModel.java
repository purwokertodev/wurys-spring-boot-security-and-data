package com.wury.boot.model;

import javax.persistence.*;

/**
 * Created by WURI on 16/03/2016.
 */
@Entity
@Table(name = "user_blog_role")
public class UserBlogRoleModel extends AbstractMyModel {

    @Column(name = "role_name", nullable = false, unique = true, length = 128)
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "user_blog_id")
    private UserBlogModel userBlogModel;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserBlogModel getUserBlogModel() {
        return userBlogModel;
    }

    public void setUserBlogModel(UserBlogModel userBlogModel) {
        this.userBlogModel = userBlogModel;
    }
}