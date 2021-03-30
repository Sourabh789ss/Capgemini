package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static void main(String[] args) {
        AbstractApplicationContext  context = new ClassPathXmlApplicationContext("appConfig.xml");
        ApplicationContextAwareTest appcontext= (ApplicationContextAwareTest)context.getBean("appcontext");
        ApplicationContext appCon =appcontext.getContext();
        Aware abc= (Aware)appCon.getBean("testA");
        abc.doTask();
        context.registerShutdownHook();
    }
}
