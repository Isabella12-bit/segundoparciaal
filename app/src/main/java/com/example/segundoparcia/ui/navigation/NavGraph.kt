package com.example.segundoparcia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.segundoparcia.presentation.BookViewModel
import com.example.segundoparcia.ui.screens.BookSearchScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    val viewModel: BookViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = "search") {
        composable("search") {
            BookSearchScreen(viewModel)
        }
    }
}