package com.example.demokotlinauth.controller

import com.example.demokotlinauth.model.Book
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class BookController {

    @GetMapping("/books")
    fun findAll(): List<Book> {
        return listOf(
                Book("The lord of the rings", BigDecimal(8)),
                Book("The lord of the rings 2", BigDecimal(5))
        );
    }
}