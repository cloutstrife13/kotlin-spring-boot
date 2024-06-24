package com.cloutstrife13.kotlin_spring_boot.models

import com.cloutstrife13.kotlin_spring_boot.entities.Book

data class BookDTO (
    val id: Int,
    val title: String,
    val description: String? = null
)

fun BookDTO.toEntity() = Book(
    id = id,
    title = title,
    description = description
)