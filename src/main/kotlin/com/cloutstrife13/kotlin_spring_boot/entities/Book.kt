package com.cloutstrife13.kotlin_spring_boot.entities

import com.cloutstrife13.kotlin_spring_boot.models.BookDTO
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity()
@Table(name = "books")
data class Book (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val title: String,
    val description: String? = null
)

fun Book.toDTO() = BookDTO(
    id = id!!,
    title = title,
    description = description
)