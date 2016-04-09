package com.wury.boot.form;

import com.wury.boot.model.UserBlogRoleModel;
import com.wury.boot.validator.EmailValidator;

import javax.persistence.Basic;
import java.util.List;

/**
 * Created by WURI on 08/04/2016.
 */
public class UserBlogForm {

    private String name = "";
    @Basic
    @EmailValidator
    private String email = "";
    private String website = "";
    private String password = "";
    private String passwordRepeated = "";
    private String pictureLocation = "";
    private List<UserBlogRoleModel> userRoles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public String getPictureLocation() {
        return pictureLocation;
    }

    public void setPictureLocation(String pictureLocation) {
        this.pictureLocation = pictureLocation;
    }

    public List<UserBlogRoleModel> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserBlogRoleModel> userRoles) {
        this.userRoles = userRoles;
    }
}
