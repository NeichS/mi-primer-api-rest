package com.api.test.primer_api.service.impl;

import com.api.test.primer_api.model.dao.UsersDao;
import com.api.test.primer_api.model.dto.UsersDto;
import com.api.test.primer_api.model.entity.Users;
import com.api.test.primer_api.service.IUsers;
import org.apache.catalina.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersImpl implements IUsers {

    @Autowired
    private UsersDao usersDao;

    @Transactional
    @Override
    public Users save(UsersDto userDto) {
        Users user = Users.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .build();
        return usersDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Users findById(Integer id) {
        return usersDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Users user) {
        usersDao.delete(user);
    }

    public List<Users> listAll() {
        return (List) usersDao.findAll();
    }
}
