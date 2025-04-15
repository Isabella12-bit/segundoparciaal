package com.example.segundoparcia.data.remote.api

import com.example.segundoparcia.data.remote.dto.BookResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLibraryApi {
    @GET("search.json")
    suspend fun searchBooks(@Query("q") query: String): BookResponseDto
}