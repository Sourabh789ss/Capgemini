package com.javaexcel.usermicroservices.controller;


import com.javaexcel.usermicroservices.model.Booking;
import com.javaexcel.usermicroservices.model.Users;
import com.javaexcel.usermicroservices.repository.UserRepository;
import com.javaexcel.usermicroservices.services.SequenceGeneratorService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static com.javaexcel.usermicroservices.model.Users.SEQUENCE_NAME;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    @HystrixCommand
    @PostMapping("/addUser")
    @ApiOperation(value = "Add User details",
            notes ="Add the details of specific user",
            response = Users.class)
    public String addUsers(@RequestBody Users users){

        //generate sequence
        users.setId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
        userRepository.save(users);
        return "Added user with id : " + users.getId();
    }

    @HystrixCommand
    @GetMapping("/user")
    @ApiOperation(value = "Find All the User details",
            notes ="Retrieve all the details of specific user",
            response = Users.class)
    public List<Users> displayAllUsers() {
        return userRepository.findAll();
    }


    @HystrixCommand
    @GetMapping("/user/{id}")
    @ApiOperation(value = "Find the User details having specific ID",
            notes ="Provide an id to look up details of specific user",
            response = Users.class)
    public Optional<Users> getUserById(@ApiParam(value = "ID value for the User you need to retrieve", required = true)
                                       @PathVariable("id") Integer id) {

        return  userRepository.findById(id);
    }


    //get by email
    @HystrixCommand
    @GetMapping("/euser/{email}")
    @ApiOperation(value = "Find the User details having specific Email",
            notes ="Provide an email to look up details of specific user",
            response = Users.class)
    public List<Users> findUserByEmail(@ApiParam(value = "Email related value for the User you need to retrieve", required = true)
                                       @PathVariable String email) {
        return userRepository.findByEmail(email);
    }

    @HystrixCommand
    @PutMapping("user/{id}")
    @ApiOperation(value = "Update the User details having specified id",
            notes ="Update the details of specific user by provide the specific details.",
            response = Users.class)
    public Users updateUser(@ApiParam(value = "ID value for the User you need to update", required = true)
                            @RequestBody Users users, @PathVariable Integer id) {
        return userRepository.findById(id)
                .map(user ->{
                    user.setId(users.getId());
                    user.setUsername(users.getUsername());
                    user.setPassword(users.getPassword());
                    user.setEmail(users.getEmail());
                    user.setMobile(users.getMobile());
                    return userRepository.save(users);
                })
                .orElseGet(()->{
                    users.setId(id);
                    return userRepository.save(users);
                });
    }

    @HystrixCommand
    @DeleteMapping("/deleteUser/{id}")
    @ApiOperation(value = "Delete User details by specific id",
            notes ="Delete the details of specific user",
            response = Users.class)
    public List<Users> deleteUsers(@ApiParam(value = "ID value for the User you need to delete", required = true)
                                  @PathVariable Integer id){
        userRepository.deleteById(id);
       // return "User deleted with id :"+ id;
        return userRepository.findAll();

    }



//Security part for subscription

  /*  @GetMapping("/dash")
    private String testingToken() {
        return "Welcome to dashboard " + SecurityContextHolder.getContext().getAuthentication().getName();
    }*/
/*




    @PostMapping("/subs")
    @ApiOperation(value = "Subscribe User details by specific id",
            notes ="subscribe the details of specific user",
            response = Users.class)
    private ResponseEntity<?> subscribeClient(@ApiParam(value = "ID value for the User you need to delete", required = true)
                                           @RequestBody AuthenticationRequest authenticationRequest){

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

       Users users =new Users();
        users.setUsername(username);
        users.setPassword(password);
        try{
            userRepository.save(users);
        }catch (Exception e){
            return ResponseEntity.ok(new AuthenticationResponse("Error during subscription for client : "+ username));
        }
        return ResponseEntity.ok(new AuthenticationResponse("successful subscription for client : "+ username));

    }
*/
    //for authenitcation

    /*
    private ResponseEntity<?> authenticateClient(@ApiParam(value = "ID value for the User you need to delete", required = true)
                                                @RequestBody AuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }
        catch(Exception e)
        {
            return ResponseEntity.ok(new AuthenticationResponse("Error during authentication for client : "+ username));

        }*/

        //authetication via wnd video
      /*  UserDetails loadedUser = userService.loadUserByUsername(username);

        String generatedToken = jwtUtils.generateToken(loadedUser);
        return ResponseEntity.ok(new AuthenticationResponse(generatedToken));

    }*/


}
