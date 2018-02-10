package main.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Макс on 10.02.2018.
 */
@Component
public class Shakespeare implements Author {

    @Autowired
    private List<Book> books;

    public Shakespeare(List<Book> books) {
        this.books = books;
    }


    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    @Override
    public void books() {
        System.out.println("Author: Shakespeare");
        for (Book book : this.books) {
            System.out.println(book.bookData());
        }
    }
}
