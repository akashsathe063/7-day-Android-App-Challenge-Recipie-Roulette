package com.mani.quotify007.presentation.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.mani.quotify007.presentation.ui.theme.QuotifyAppTheme
import com.mani.quotify007.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()
    /* Collect the current state from the ViewModel as a State object.
    * the state is preserved across configuration changes and the UI is updated reactively */
    val state = viewModel.state.collectAsState().value
    Scaffold(
        bottomBar = { BottomAppBar(navController) }
    ) { innerPadding ->
        NavigationGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            state = state,
            quotes = state.quotes,
            favoriteQuotes = state.favoriteQuotes,
            onEvent = { event -> viewModel.onEvent(event) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    QuotifyAppTheme {
        MainScreen()
    }
}