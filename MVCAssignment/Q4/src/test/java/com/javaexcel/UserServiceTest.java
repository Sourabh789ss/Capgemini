package com.javaexcel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javaexcel.model.Login;
import com.javaexcel.model.User;
import com.javaexcel.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/config/user-beans.xml" })
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegister() {
        User user = new User();
        user.setUsername("singh");
        user.setPassword("singh123");
        user.setEmail("singh@gmail.com");

        int result = userService.register(user);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testValidateUser() {
        Login login = new Login();
        login.setUsername("singh");
        login.setPassword("singh123");

        User user = userService.validateUser(login);
        Assert.assertEquals("singh", user.getUsername());
    }

}