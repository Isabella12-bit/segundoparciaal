package com.example.segundoparcia.data.remote.dto

data class BookResponseDto(
    val docs: List<BookDto>
)

data class BookDto(
    val title: String?,
    val author_name: List<String>?,
    val first_publish_year: Int?
)
