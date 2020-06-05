package com.khai.shelemonchak;

import com.khai.shelemonchak.services.TestsServicesImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMainClass {
    public static void main (String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        TestsServicesImpl test = context.getBean(TestsServicesImpl.class);
        test.runTest();
        test.getScore();
    }
}
