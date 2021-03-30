package com.javaexcel;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
public class Bean3 {
    @PostConstruct
    public void customInit()
    {
        System.out.println("Method customInit() invoked...");
    }

    @PreDestroy
    public void customDestroy()
    {
        System.out.println("Method customDestroy() invoked...");
    }
}
