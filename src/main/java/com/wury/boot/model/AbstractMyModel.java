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

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author WURI Super class untuk semua class model/entity
 * super class for all entity class
 */
@MappedSuperclass
public abstract class AbstractMyModel implements IMyModel {

    @Id
    @Type(type = "pg-uuid")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    
    @Column(name = "created_at", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;
    
    @Column(name = "created_by_id", nullable = false)
    @Type(type = "pg-uuid")
    private UUID createdById;
    
    @Column(name = "updated_at", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updatedAt;
    
    @Column(name = "updated_by_id", nullable = false)
    @Type(type = "pg-uuid")
    private UUID updatedById;
    
    @Column(name = "deleted_at")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deletedAt;
    
    @Column(name = "deleted_by_id")
    @Type(type = "pg-uuid")
    private UUID deletedById;

    public AbstractMyModel(){}

    public AbstractMyModel(Date createdAt, UUID createdById, Date updatedAt, UUID updatedById) {
        this.createdAt = createdAt;
        this.createdById = createdById;
        this.updatedAt = updatedAt;
        this.updatedById = updatedById;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getCreatedById() {
        return createdById;
    }

    public void setCreatedById(UUID createdById) {
        this.createdById = createdById;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UUID getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(UUID updatedById) {
        this.updatedById = updatedById;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public UUID getDeletedById() {
        return deletedById;
    }

    public void setDeletedById(UUID deletedById) {
        this.deletedById = deletedById;
    }
    
    

}
