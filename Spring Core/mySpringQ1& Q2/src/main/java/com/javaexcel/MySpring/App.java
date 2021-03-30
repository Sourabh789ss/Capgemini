package com.javaexcel.MySpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    public static void main( String[] args ){


    }
    public String customerCase() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Customer customer = (Customer)context.getBean("customer");
        String value = customer.toString();
        return value;
    }
    public String listQuestion(){
        ListQuestion listq = (ListQuestion)context.getBean("listQuestion");
        return listq.toString();
    }
    public String setQuestion() {
        SetQuestion setq = (SetQuestion)context.getBean("setQuestion");
        return setq.toString();
    }
    public String mapQuestion() {
        MapQuestion mapq = (MapQuestion)context.getBean("mapQuestion");
        return mapq.toString();
    }
}