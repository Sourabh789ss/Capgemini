package com.javaexcel.usermicroservices.repository;

import com.javaexcel.usermicroservices.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<Users, Integer> {

   public List<Users> findByEmail(String email);
  // public List<Users> findByEmailPassword(String email,String password);

    //Users findByUsername(String username);
    /*public List<Users> findByRole(String role);*/

}
