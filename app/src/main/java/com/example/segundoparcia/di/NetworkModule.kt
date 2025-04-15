package com.example.segundoparcia.di

import com.example.segundoparcia.data.remote.api.OpenLibraryApi
import com.example.segundoparcia.data.repository.BookRepositoryImpl
import com.example.segundoparcia.domain.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://openlibrary.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): OpenLibraryApi =
        retrofit.create(OpenLibraryApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(api: OpenLibraryApi): BookRepository =
        BookRepositoryImpl(api)
}