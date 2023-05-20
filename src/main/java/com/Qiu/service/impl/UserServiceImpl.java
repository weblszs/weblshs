package com.Qiu.service.impl;

import com.Qiu.dao.UserDao;
import com.Qiu.domain.User;
import com.Qiu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public User getByAll(String email, String password) {
        return userDao.getByAll(email,password);
    }

    @Override
    public User getByEmail(String email) {
        return  userDao.getByEmail(email);
    }

    @Override
    public boolean save(User user) {
        return  userDao.save(user) > 0 ;
    }


}
