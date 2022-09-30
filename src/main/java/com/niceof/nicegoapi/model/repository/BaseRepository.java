package com.niceof.nicegoapi.model.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.niceof.nicegoapi.model.entity.BaseEntity;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, I extends Serializable> 
    extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {
    
}
