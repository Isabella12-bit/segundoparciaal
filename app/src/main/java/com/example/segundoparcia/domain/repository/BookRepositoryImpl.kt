package com.example.segundoparcia.data.repository

import com.example.segundoparcia.data.remote.api.OpenLibraryApi
import com.example.segundoparcia.data.remote.mapper.toDomain
import com.example.segundoparcia.domain.model.Book
import com.example.segundoparcia.domain.repository.BookRepository
import com.example.segundoparcia.data.remote.mapper.toDomain
import com.example.segundoparcia.data.local.toEntity
import com.example.segundoparcia.data.local.toDomain
import com.example.segundoparcia.data.local.BookDao


class BookRepositoryImpl(
    private val api: OpenLibraryApi,
    private val dao: BookDao
) : BookRepository {

    override suspend fun searchBooks(query: String): List<Book> {
        val response = api.searchBooks(query)
        return response.docs.map { it.toDomain() }
    }

    override suspend fun saveBook(book: Book) {
        dao.insertBook(book.toEntity())
    }

    override suspend fun getLikedBooks(): List<Book> {
        return dao.getAllLikedBooks().map { it.toDomain() }
    }
}