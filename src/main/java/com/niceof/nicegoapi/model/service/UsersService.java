package com.niceof.nicegoapi.model.service;

import com.niceof.nicegoapi.model.entity.Users;

public interface UsersService {
    Users findById(Integer id);
    Users findByUsername(String username);
}
