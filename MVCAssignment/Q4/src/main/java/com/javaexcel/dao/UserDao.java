package com.javaexcel.dao;


import com.javaexcel.model.Login;
import com.javaexcel.model.User;

public interface UserDao {

    int register(User user);

    User validateUser(Login login);
}