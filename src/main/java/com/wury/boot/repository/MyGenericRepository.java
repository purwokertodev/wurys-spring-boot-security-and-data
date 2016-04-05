package com.wury.boot.repository;

import com.wury.boot.model.UserBlog;
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


    /**
     * My Custom method
     *
     */
    T save(T model, UserBlog author);

    boolean isDeleted(T model);

    Boolean delete(T model, UserBlog userBlog);

    void remove(T model);


}
