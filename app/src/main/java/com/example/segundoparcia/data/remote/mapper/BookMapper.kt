package com.example.segundoparcia.data.remote.mapper

import com.example.segundoparcia.data.remote.dto.BookDto
import com.example.segundoparcia.domain.model.Book
import com.example.segundoparcia.data.local.BookEntity

fun BookDto.toDomain(): Book {
    return Book(
        title = title.orEmpty(),
        authors = author_name ?: emptyList(),
        year = first_publish_year ?: 0
    )
}

fun Book.toEntity(): BookEntity {
    return BookEntity(
        title = this.title,
        authors = this.authors.joinToString(", "),
        publishYear = this.year.toString()
    )
}

