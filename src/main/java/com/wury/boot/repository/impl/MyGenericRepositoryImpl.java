package com.wury.boot.repository.impl;

import com.wury.boot.model.AbstractMyModel;
import com.wury.boot.model.UserBlogModel;
import com.wury.boot.repository.MyGenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by WURI on 04/04/2016.
 */
@NoRepositoryBean
public class MyGenericRepositoryImpl<T extends AbstractMyModel, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MyGenericRepository<T, ID> {


    protected Class<T> entity;

    private final EntityManager entityManager;
    private final JpaEntityInformation<T, ?> entityInformation;
    private Class<?> springDataRepositoryInterface;

    public MyGenericRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
    }



    public Class<?> getSpringDataRepositoryInterface() {
        return springDataRepositoryInterface;
    }

    public void setSpringDataRepositoryInterface(Class<?> springDataRepositoryInterface) {
        this.springDataRepositoryInterface = springDataRepositoryInterface;
    }


    @Override
    @Transactional
    public T save(T model, UserBlogModel author) {
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
    public Boolean delete(T model, UserBlogModel userBlogModel) {
        model.setDeletedById(userBlogModel.getId());
        model.setDeletedAt(new Date());
        this.save(model);
        return true;
    }

    @Override
    public void remove(T model) {
        super.delete(model);
    }

    @Override
    public List<T> findAll(Sort sort) {
        return super.findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return super.findAll(pageable);
    }
}
