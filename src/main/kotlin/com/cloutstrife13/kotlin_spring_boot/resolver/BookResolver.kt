package com.cloutstrife13.kotlin_spring_boot.resolver

import com.cloutstrife13.kotlin_spring_boot.model.Book
import com.cloutstrife13.kotlin_spring_boot.service.BookService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class BookResolver(
    private val bookService: BookService
) {

    @QueryMapping
    fun getAllBooks(): List<Book> {
        return bookService.getAllBooks()
    }

    @QueryMapping
    fun getBookById(@Argument id: UUID): Book? {
        return bookService.getBookById(id)
    }

    @MutationMapping
    fun createBook(@Argument title: String, @Argument description: String?): Book {
        return bookService.createBook(title, description)
    }
}