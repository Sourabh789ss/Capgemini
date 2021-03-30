package com.javaexcel.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App<details> {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        /*
         * System.out.println("Mentor Details"); Mentor mentor =
         * (Mentor)context.getBean("mentor"); System.out.println(mentor);
         */
        System.out.println("All Details from details class");
        Details details = (Details) context.getBean("details");
        System.out.println(details);
    }


}
