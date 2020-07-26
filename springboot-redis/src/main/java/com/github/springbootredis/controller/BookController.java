package com.github.springbootredis.controller;

import com.github.springbootredis.entity.Book;
import com.github.springbootredis.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * redis 做数据库测试
 */
@RequestMapping("/books")
@RestController
public class BookController {

    private final BooksRepository repository;

    public BookController(BooksRepository repository) {
        this.repository = repository;
    }


    @GetMapping("")
    public List<Book> findAll() {
        return repository.findAll();
    }

    @PostMapping("")
    public String newBook(@RequestBody Book newBook) {
        repository.save(newBook);
        return "Added";
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/del")
    public void deleteAll(){
        repository.deleteAll();
    }
}
