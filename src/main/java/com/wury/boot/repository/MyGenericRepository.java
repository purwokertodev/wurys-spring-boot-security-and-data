package com.wury.boot.repository;

import com.wury.boot.model.UserBlogModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by WURI on 04/04/2016.
 */
@NoRepositoryBean
public interface MyGenericRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

    /**
     * Spring data method
     *
     */
    void delete(T deleted);

    T findOne(ID id);

    List<T> findAll();

    <S extends T> S save(S model);

    List<T> findAll(Sort orders);


    /**
     * My Custom method
     *
     */
    T save(T model, UserBlogModel author);

    boolean isDeleted(T model);

    Boolean delete(T model, UserBlogModel userBlogModel);

    void remove(T model);


}
