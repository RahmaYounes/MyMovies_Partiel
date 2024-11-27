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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import rahma.androidfirst.mymovies.ui.theme.CustomColor

@Composable
fun ActorScreen(windowSizeClass: WindowSizeClass, innernavController: NavController) {
    val classeHauteur = windowSizeClass.heightSizeClass
    val classeLargeur = windowSizeClass.widthSizeClass

    when (classeLargeur) {
        WindowWidthSizeClass.Compact -> {
            LayoutVerticalActor(Modifier, windowSizeClass, innernavController)
        }
        else -> {
            Row(
                Modifier
                    .fillMaxSize()
                    .background(CustomColor),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LayoutHorizontalActor(Modifier, windowSizeClass, innernavController)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutVerticalActor(modifier: Modifier = Modifier, windowSizeClass: WindowSizeClass, innernavController: NavController) {
    val viewModel: ViewModelperson = viewModel()
    val persons by viewModel.listpersons.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    Column {
        SearchBar(
            query = searchQuery,
            onQueryChange = { viewModel.searchPersons(it) }
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
            items(persons) { person ->
                Card(
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
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(person.profile_path?.let { "https://image.tmdb.org/t/p/w780/$it" } ?: R.drawable.placeholder)
                                .placeholder(R.drawable.placeholder)
                                .error(R.drawable.placeholder)
                                .build(),
                            contentDescription = null,
                            modifier = Modifier.background(CustomColor)
                        )
                        Spacer(modifier = Modifier.size(3.dp))
                        Text(
                            text = person.name,
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutHorizontalActor(modifier: Modifier = Modifier, windowSizeClass: WindowSizeClass, innernavController: NavController) {
    val viewModel: ViewModelperson = viewModel()
    val persons by viewModel.listpersons.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    Column {
        SearchBar(
            query = searchQuery,
            onQueryChange = { viewModel.searchPersons(it) }
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
            items(persons) { person ->
                Card(
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
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(person.profile_path?.let { "https://image.tmdb.org/t/p/w780/$it" } ?: R.drawable.placeholder)
                                .placeholder(R.drawable.placeholder)
                                .error(R.drawable.placeholder)
                                .build(),
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp)
                                .background(CustomColor)
                        )
                        Spacer(modifier = Modifier.size(3.dp))
                        Text(
                            text = person.name,
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