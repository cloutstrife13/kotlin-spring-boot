package com.cloutstrife13.kotlin_spring_boot.model

import java.util.UUID

data class Book (
    val id: UUID,
    val title: String,
    val description: String? = null
)