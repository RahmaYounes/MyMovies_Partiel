package rahma.androidfirst.mymovies

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
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
import rahma.androidfirst.mymovies.ui.theme.CustomColor

@Composable
fun SerieScreen(windowSizeClass: WindowSizeClass, innernavController: NavController) {
    val classeHauteur = windowSizeClass.heightSizeClass
    val classeLargeur = windowSizeClass.widthSizeClass

    when (classeLargeur) {
        WindowWidthSizeClass.Compact -> {
            LayoutverticalSerie(Modifier, windowSizeClass, innernavController)
        }
        else -> {
            Row(
                Modifier
                    .fillMaxSize()
                    .background(CustomColor),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LayouthorizontalSerie(Modifier, windowSizeClass, innernavController)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutverticalSerie(modifier: Modifier = Modifier, windowSizeClass: WindowSizeClass, innernavController: NavController) {
    val viewModel: ViewModelserie = viewModel()
    val series by viewModel.listtvs.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    Column {
        SearchBar(
            query = searchQuery,
            onQueryChange = { viewModel.searchSeries(it) }
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
            items(series) { tv ->
                SerieCard(tv, innernavController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayouthorizontalSerie(modifier: Modifier = Modifier, windowSizeClass: WindowSizeClass, innernavController: NavController) {
    val viewModel: ViewModelserie = viewModel()
    val series by viewModel.listtvs.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    Column {
        SearchBar(
            query = searchQuery,
            onQueryChange = { viewModel.searchSeries(it) }
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .padding(start = 30.dp, top = 30.dp, end = 16.dp)
                .fillMaxSize()
                .background(CustomColor),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(series) { tv ->
                SerieCard(tv, innernavController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SerieCard(tv: Tv, innernavController: NavController) {
    var isFavorite by remember { mutableStateOf(false) }
    Card(
        onClick = { innernavController.navigate("DetailsSerie/" + tv.id) },
        modifier = Modifier
            .fillMaxWidth()
            .background(CustomColor),
        colors = CardDefaults.cardColors(containerColor = CustomColor)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(CustomColor)
        ) {
            Box {
                AsyncImage(
                    model = ("https://image.tmdb.org/t/p/w780/" + tv.poster_path),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(CustomColor)
                )
                IconButton(
                    onClick = { isFavorite = !isFavorite },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = null,
                        tint = if (isFavorite) Color.Red else Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.size(4.dp)) // Reduced space
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp), // Adjust height as needed
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = tv.name,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.size(4.dp)) // Reduced space
        }
    }
}