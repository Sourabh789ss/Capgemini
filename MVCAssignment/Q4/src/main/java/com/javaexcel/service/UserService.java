package com.javaexcel.service;

import com.javaexcel.model.Login;
import com.javaexcel.model.User;

public interface UserService {

    int register(User user);

    User validateUser(Login login);
}