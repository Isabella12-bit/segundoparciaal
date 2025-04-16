package com.example.segundoparcia.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.segundoparcia.domain.model.Book
import com.example.segundoparcia.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.segundoparcia.domain.usecase.SearchBooksUseCase
import com.example.segundoparcia.domain.usecase.SaveBookUseCase

@HiltViewModel
class BookViewModel @Inject constructor(
    private val repository: BookRepository,
    private val searchBooksUseCase: SearchBooksUseCase,
    private val saveBookUseCase: SaveBookUseCase
) : ViewModel() {

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books

    fun search(query: String) {
        viewModelScope.launch {
            try {
                _books.value = searchBooksUseCase(query)
            } catch (e: Exception) {
                _books.value = emptyList()
            }
        }
    }

    fun saveBook(book: Book) {
        viewModelScope.launch {
            saveBookUseCase(book)
        }
    }

    private val _likedBooks = MutableStateFlow<List<Book>>(emptyList())
    val likedBooks: StateFlow<List<Book>> = _likedBooks

    fun getLikedBooks() {
        viewModelScope.launch {
            _likedBooks.value = repository.getLikedBooks()
        }
    }
}