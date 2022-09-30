package com.niceof.nicegoapi.model.service;

import com.niceof.nicegoapi.model.entity.Users;

public interface UsersService extends BaseService<Users, Integer> {
    Users findByUsername(String username);
}
