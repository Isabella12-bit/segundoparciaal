package com.example.segundoparcia.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.segundoparcia.domain.model.Book
import com.example.segundoparcia.presentation.BookViewModel
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController

@Composable
fun BookSearchScreen(viewModel: BookViewModel, navController: NavHostController) {
    var query by remember { mutableStateOf("") }
    val books by viewModel.books.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Buscar libro") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Ambos botones en fila
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { viewModel.search(query) }) {
                Text("Buscar")
            }
            Button(onClick = { navController.navigate("liked_books") }) {
                Text("Ver guardados")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(books) { book ->
                BookItem(book = book, viewModel = viewModel)
            }
        }
    }
}

@Composable
fun BookItem(book: Book, viewModel: BookViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(book.title, style = MaterialTheme.typography.titleMedium)
            Text("Autor: ${book.authors.joinToString()}")
            Text("Año: ${book.year}")
            IconButton(onClick = {
                viewModel.saveBook(book)
            }) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "Me gusta", tint = MaterialTheme.colorScheme.primary)
            }
        }
    }
}
