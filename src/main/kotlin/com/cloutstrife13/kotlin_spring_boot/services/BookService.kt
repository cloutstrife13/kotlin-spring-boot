package com.cloutstrife13.kotlin_spring_boot.services

import com.cloutstrife13.kotlin_spring_boot.entities.Book
import com.cloutstrife13.kotlin_spring_boot.entities.toDTO
import com.cloutstrife13.kotlin_spring_boot.models.BookDTO
import com.cloutstrife13.kotlin_spring_boot.repositories.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService(@Autowired private val repository: BookRepository) {

    fun getAllBooks(): List<BookDTO> {
        val books = repository.findAll().toList()
        val bookDtos = books.stream().map { book -> book.toDTO() }.toList()

        return bookDtos
    }

    fun getBookById(id: Int): BookDTO? {
        val book = repository.findById(id).orElse(null)

        book?.let {
            val bookDto = book.toDTO()
            return bookDto
        } ?: run {
            return null
        }
    }

    fun createBook(title: String, description: String?): BookDTO {
        val newBook = Book(title = title, description = description)

        repository.save(newBook)

        val bookDto = newBook.toDTO()

        return bookDto
    }
}