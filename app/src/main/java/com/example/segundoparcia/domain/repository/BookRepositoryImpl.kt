package com.example.segundoparcia.data.repository

import com.example.segundoparcia.data.remote.api.OpenLibraryApi
import com.example.segundoparcia.data.remote.mapper.toDomain
import com.example.segundoparcia.domain.model.Book
import com.example.segundoparcia.domain.repository.BookRepository

class BookRepositoryImpl(
    private val api: OpenLibraryApi
): BookRepository {
    override suspend fun searchBooks(query: String): List<Book> {
        return api.searchBooks(query).docs.map { it.toDomain() }
    }
}
