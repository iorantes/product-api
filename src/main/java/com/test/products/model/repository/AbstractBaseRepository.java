package com.test.products.model.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.test.products.model.entity.AbstractBaseEntity;

@NoRepositoryBean
public interface AbstractBaseRepository <T extends AbstractBaseEntity, ID extends Serializable> extends JpaRepository<T, ID>{

}
