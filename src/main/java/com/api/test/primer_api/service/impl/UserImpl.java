package com.api.test.primer_api.service.impl;

import com.api.test.primer_api.model.dao.UserDao;
import com.api.test.primer_api.model.entity.User;
import com.api.test.primer_api.service.IUser;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements IUser {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}
