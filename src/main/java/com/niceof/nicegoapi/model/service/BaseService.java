package com.niceof.nicegoapi.model.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, I extends Serializable> {
    T findById(I id);
    List<T> findAll();
}
