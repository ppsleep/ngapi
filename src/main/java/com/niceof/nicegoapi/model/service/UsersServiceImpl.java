package com.niceof.nicegoapi.model.service;

import org.springframework.stereotype.Service;
import com.niceof.nicegoapi.model.entity.Users;
import com.niceof.nicegoapi.model.repository.BaseRepository;
import com.niceof.nicegoapi.model.repository.UsersRepository;

@Service
public class UsersServiceImpl extends BaseServiceImpl<Users, Integer> implements UsersService {
    
    private final UsersRepository usersRepository;

    public UsersServiceImpl(final UsersRepository userDao) {
        this.usersRepository = userDao;
    }

    @Override
    public BaseRepository<Users, Integer> getBaseRepository() {
        return this.usersRepository;
    }

    @Override
    public Users findById(Integer id) {
        return usersRepository.findById(id).get();
    }
    @Override
    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
