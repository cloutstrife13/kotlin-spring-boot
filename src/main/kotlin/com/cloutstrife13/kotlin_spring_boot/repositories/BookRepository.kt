package com.cloutstrife13.kotlin_spring_boot.repositories

import com.cloutstrife13.kotlin_spring_boot.entities.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Int>