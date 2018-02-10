package main.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Макс on 10.02.2018.
 */
@Component
@Order(value=1)
public class Hamlet implements Book {
    private String bookName;
    private int year;
    private String genre;

    public Hamlet(String bookName, int year, String genre) {
        this.bookName = bookName;
        this.year = year;
        this.genre = genre;
    }

    @Override
    public String bookData() {
        return "BookName: " + this.bookName + " Year: " + this.year + " Genre: " + this.genre;
    }
}