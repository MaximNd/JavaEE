package main.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Макс on 29.01.2018.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("main/resources/config.xml");

        System.out.println("Впровадження залежностей через конструктор\n");
        Performer performer1 = (Performer)context.getBean("duke");
        performer1.perform();
        System.out.println("\n");


        Performer performer2 = (Performer)context.getBean("poeticDuke");
        performer2.perform();
        System.out.println("\n");

        System.out.println("Впровадження залежностей через поля\n");
        Performer performer4 = (Performer)context.getBean("kenny");
        performer4.perform();
        System.out.println("\n");

        System.out.println("Впровадження списків\n");
        Performer performer3 = (Performer)context.getBean("hank");
        performer3.perform();
    }
}
