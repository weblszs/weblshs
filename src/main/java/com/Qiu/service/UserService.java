package com.Qiu.service;

import com.Qiu.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {


    public User getByEmail(String email);

    public boolean save(User user);

    public  User getByAll(String email,String password);


    public User login(User user);

}
