/*
   **********************************************************************
   **********************************************************************
   ** By Wuriyanto                                                     **
   ** EMAIL/FACEBOOK : wuriyanto48@yahoo.co.id  OR  Prince Wury        **
   ** WEBSITE : wuriyantoinformatika.blogspot.com                      **
   ** CITY : BANJARNEGARA CENTRAL JAVA INDONESIA                       **
   ** COMPUTER SCIENCE                                                 **
   ** MUHAMMADIYAH UNIVERSITY OF PURWOKERTO                            **
   ** NB:BEBAS DIDISTRIBUSIKAN UNTUK TUJUAN BELAJAR                    **      
   **                                                                  **
   **                                     JMAT.inc & Black Code Studio **
   **********************************************************************
   **********************************************************************

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wury.boot.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 *
 * @author WURI
 */
@Entity
@Table(name = "user_blog")
public class UserBlogModel extends AbstractMyModel{
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "website", nullable = false)
    private String website;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "picture_location", nullable = false)
    private String pictureLocation;

    @OneToMany(mappedBy = "userBlogModel", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
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
