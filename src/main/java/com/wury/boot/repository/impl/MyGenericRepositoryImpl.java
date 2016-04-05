package com.wury.boot.repository.impl;

import com.wury.boot.model.AbstractMyModel;
import com.wury.boot.model.UserBlog;
import com.wury.boot.repository.MyGenericRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by WURI on 04/04/2016.
 */
@NoRepositoryBean
public class MyGenericRepositoryImpl<T extends AbstractMyModel, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MyGenericRepository<T, ID> {

    protected Class<T> entity;

    private final EntityManager entityManager;
    private final JpaEntityInformation<T, ?> entityInformation;
    private Class<?> springDateRepositoryInterface;

    public MyGenericRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
    }



    public Class<?> getSpringDateRepositoryInterface() {
        return springDateRepositoryInterface;
    }

    public void setSpringDateRepositoryInterface(Class<?> springDateRepositoryInterface) {
        this.springDateRepositoryInterface = springDateRepositoryInterface;
    }


    @Override
    @Transactional
    public T save(T model, UserBlog author) {
        if(this.entityInformation.isNew(model)){
            model.setCreatedById(author.getId());
            model.setCreatedAt(new Date());
        }

        model.setUpdatedById(author.getId());
        model.setUpdatedAt(new Date());
        model = this.save(model);
        return model;
    }

    @Override
    public boolean isDeleted(T model) {
        if(model.getDeletedAt() != null){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean delete(T model, UserBlog userBlog) {
        model.setDeletedById(userBlog.getId());
        model.setDeletedAt(new Date());
        this.save(model);
        return true;
    }

    @Override
    public void remove(T model) {
        super.delete(model);
    }
}
