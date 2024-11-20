package rahma.androidfirst.mymovies

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

val CustomColor = Color(0xFFf3f4f6) // Define your custom color

@Composable
fun MoviesScreen(windowSizeClass: WindowSizeClass, innernavController: NavController) {
    val classeHauteur = windowSizeClass.heightSizeClass
    val classeLargeur = windowSizeClass.widthSizeClass

    when (classeLargeur) {
        WindowWidthSizeClass.Compact -> {
            LayoutverticalFilm(Modifier, windowSizeClass, innernavController)
        }
        else -> {
            Row(
                Modifier
                    .fillMaxSize()
                    .background(CustomColor),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LayouthorizontalFilm(Modifier, windowSizeClass, innernavController)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutverticalFilm(modifier: Modifier = Modifier, windowSizeClass: WindowSizeClass, innernavController: NavController) {
    val ViewModel: MainViewModel = viewModel()
    val films = ViewModel.listmovies.collectAsState()
    val searchQuery by ViewModel.searchQuery.collectAsState()

    Column {
        SearchBar(
            query = searchQuery,
            onQueryChange = { ViewModel.searchMovies(it) }
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(start = 9.dp, top = 30.dp, end = 9.dp)
                .fillMaxSize()
                .background(CustomColor),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(films.value) { film ->
                Card(
                    onClick = { innernavController.navigate("DescFILM/" + film.id) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(CustomColor),
                    colors = CardDefaults.cardColors(containerColor = CustomColor)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.background(CustomColor)
                    ) {
                        AsyncImage(
                            model = ("https://image.tmdb.org/t/p/w780/" + film.poster_path),
                            contentDescription = null,
                            modifier = Modifier.background(CustomColor)
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(
                            text = film.title,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayouthorizontalFilm(modifier: Modifier = Modifier, windowSizeClass: WindowSizeClass, innernavController: NavController) {
    val ViewModel: MainViewModel = viewModel()
    val films = ViewModel.listmovies.collectAsState()
    val searchQuery by ViewModel.searchQuery.collectAsState()

    Column {
        SearchBar(
            query = searchQuery,
            onQueryChange = { ViewModel.searchMovies(it) }
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .padding(start = 16.dp, top = 30.dp, end = 16.dp)
                .fillMaxSize()
                .background(CustomColor),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(films.value) { film ->
                Card(
                    onClick = { innernavController.navigate("DescFilm/" + film.id) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(CustomColor),
                    colors = CardDefaults.cardColors(containerColor = CustomColor)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.background(CustomColor)
                    ) {
                        AsyncImage(
                            model = ("https://image.tmdb.org/t/p/w780/" + film.poster_path),
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp)
                                .background(CustomColor)
                        )
                        Spacer(modifier = Modifier.size(3.dp))
                        Text(
                            text = film.title,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.size(13.dp))
                    }
                }
            }
        }
    }
}