/*
package com.javaexcel.usermicroservices;

import com.javaexcel.usermicroservices.controller.UserController;
import com.javaexcel.usermicroservices.model.Users;
import com.javaexcel.usermicroservices.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static reactor.core.publisher.Mono.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class UsermicroservicesApplicationTests {

    @Autowired
    private UserController userController;

    @MockBean
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        userRepository = mock(UserRepository.class);
    }

    @Test
    public void getBookingByEmailTest(){

        String email="Sourabh@gmail.com";
        Mockito.when(userRepository.findByEmail(email)).thenReturn(Stream.of(new Users(67, "Sourabh","string", "Sourabh@gmail.com","8351065402")).collect(Collectors.toList()));

        assertEquals(1,userRepository.findByEmail(email).size());

    }

    @Test
    public void getUsersTest(){
          Mockito.when(userRepository.findAll()).thenReturn(Stream.of(
                   new Users(67, "Sourabh","string", "Sourabh@gmail.com","8351065402"),
                   new Users(68,"Sourabh789", "string123","Sourabh789@gmail.com","9805211145")).collect(Collectors.toList()));
        assertEquals(2, userController.displayAllUsers().size());
    }



    @Test
    public void saveUserTest(){
        Users users = new Users(70,"Sagar", "pass","Sagar@gmail.com","7018090196");
        Mockito.when(userRepository.save(users)).thenReturn(users);
        assertEquals(users, userController.addUsers(users));
    }
    @Test
    public void RemoveUsersTest(){
        Users users = new Users(2,"Sagar", "pass","Sagar@gmail.com","7018090196");
       userController.deleteUsers(users.getId());
        verify(userRepository, times(1)).delete(users);
    }

}
*/
