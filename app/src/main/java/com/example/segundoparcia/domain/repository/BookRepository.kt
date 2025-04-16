package com.example.segundoparcia.domain.repository

import com.example.segundoparcia.domain.model.Book

interface BookRepository {
    suspend fun searchBooks(query: String): List<Book>
    suspend fun saveBook(book: Book)
    suspend fun getLikedBooks(): List<Book>
}
