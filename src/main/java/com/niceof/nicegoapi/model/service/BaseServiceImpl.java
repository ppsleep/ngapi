package com.niceof.nicegoapi.model.service;

import java.io.Serializable;
import java.util.List;

import com.niceof.nicegoapi.model.entity.BaseEntity;
import com.niceof.nicegoapi.model.repository.BaseRepository;

public abstract class BaseServiceImpl<T extends BaseEntity, I extends Serializable> implements BaseService<T, I> {

    public abstract BaseRepository<T, I> getBaseRepository();

    @Override
    public T findById(I id) {
        return getBaseRepository().findById(id).get();
    }

    @Override
    public List<T> findAll() {
        return getBaseRepository().findAll();
    }
}
