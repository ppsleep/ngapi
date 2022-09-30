package com.niceof.nicegoapi.model.repository;

import org.springframework.stereotype.Repository;
import com.niceof.nicegoapi.model.entity.Users;

@Repository
public interface UsersRepository extends BaseRepository<Users, Integer> {
    Users findByUsername(String username);
}
