package com.javaexcel.CustomerProd.Service;

import com.javaexcel.CustomerProd.Model.Customer;
import com.javaexcel.CustomerProd.RabbitMQConfig;
import com.javaexcel.CustomerProd.Repo.CustomerRepo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer-service")
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    AmqpTemplate amqpTemplate;

    /*@Autowired
    RabbitMQConfig rabbitMQConfig = new RabbitMQConfig();*/

    @PostMapping("add-customer")
    public String addCustomer(@RequestBody Customer customer){
        amqpTemplate.convertAndSend(RabbitMQConfig.topicExchange,RabbitMQConfig.routingKey,customer);
        return "Customer added";
    }

    @GetMapping("/get-customers")
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }
}
