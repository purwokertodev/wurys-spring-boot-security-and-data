package com.wury.boot.config;

import com.wury.boot.repository.impl.MyGenericRepositoryImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by WURI on 15/03/2016.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.wury.boot.model"})
@EnableJpaRepositories(basePackages = {"com.wury.boot.repository"}, repositoryBaseClass = MyGenericRepositoryImpl.class)
@EnableTransactionManagement
public class RepositoryConfig {

}
