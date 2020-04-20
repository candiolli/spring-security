package com.example.demospringsecuritydb.controller;

import com.example.demospringsecuritydb.model.Book;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Validated
public class BookController {

    // Find
    @GetMapping("/books")
    List<Book> findAll() {
//        return repository.findAll();

        List<Book> livros = new ArrayList<Book>();
        livros.addAll(
                Arrays.asList(
                        new Book("Livro 1", new BigDecimal(1)),
                        new Book("Livro 1", new BigDecimal(1))
                ));
        return livros;
    }

}
