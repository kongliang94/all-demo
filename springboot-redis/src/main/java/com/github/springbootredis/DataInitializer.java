package com.github.springbootredis;

import com.github.springbootredis.entity.Book;
import com.github.springbootredis.repository.BooksRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 初始化数据类
 */
//@Component
public class DataInitializer implements CommandLineRunner {

    private final BooksRepository books;

    public DataInitializer(BooksRepository books) {
        this.books = books;
    }

    @Override
    public void run(String[] args) {
        for (int i = 0; i < 3; i++) {
            Book book=new Book();
            book.setId(Long.valueOf(i));
            book.setName("book"+i);
            book.setAutherName("KK");
            this.books.save(book);
        }

    }

}
