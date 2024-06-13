package com.cloutstrife13.kotlin_spring_boot.service

import com.cloutstrife13.kotlin_spring_boot.model.Book
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService {

    companion object {
        private val books = mutableListOf(Book(id = UUID.randomUUID(), title = "title 1"),Book(id = UUID.randomUUID(), title = "title 2"))
    }

    fun getAllBooks(): List<Book> {
        return books
    }

    fun getBookById(id: UUID): Book? {
        return books.firstOrNull { it.id == id }
    }

    fun createBook(title: String, description: String?): Book {
        val newBook = Book(id = UUID.randomUUID(), title, description)

        books.add(newBook)

        return newBook
    }
}