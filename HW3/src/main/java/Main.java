package main.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Макс on 10.02.2018.
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("main/resources/config.xml");

        Author shakespeare = (Author)context.getBean("shakespeare");
        shakespeare.books();
    }
}
