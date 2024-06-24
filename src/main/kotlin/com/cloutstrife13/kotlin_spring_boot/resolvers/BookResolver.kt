package com.cloutstrife13.kotlin_spring_boot.resolvers

import com.cloutstrife13.kotlin_spring_boot.models.BookDTO
import com.cloutstrife13.kotlin_spring_boot.services.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class BookResolver(
    @Autowired private val bookService: BookService
) {

    @QueryMapping
    fun getAllBooks(): List<BookDTO> {
        return bookService.getAllBooks()
    }

    @QueryMapping
    fun getBookById(@Argument id: Int): BookDTO? {
        return bookService.getBookById(id)
    }

    @MutationMapping
    fun createBook(@Argument title: String, @Argument description: String?): BookDTO {
        return bookService.createBook(title, description)
    }
}