package rahma.androidfirst.mymovies

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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


@Composable
fun SerieScreen(windowSizeClass: WindowSizeClass,innernavController: NavController){
    val classeHauteur = windowSizeClass.heightSizeClass
    val classeLargeur = windowSizeClass.widthSizeClass

    when (classeLargeur) {
        WindowWidthSizeClass.Compact -> {
            LayoutverticalSerie(Modifier, windowSizeClass ,innernavController)
        }
        else -> {
            Row(Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically) {
                LayouthorizontalSerie(Modifier, windowSizeClass,innernavController)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutverticalSerie(modifier: Modifier = Modifier, windowSizeClass: WindowSizeClass, innernavController :NavController) {

    val ViewModel : ViewModelserie = viewModel()
    val films = ViewModel.listtvs.collectAsState()


    LazyVerticalGrid( columns = GridCells.Fixed(2),
        modifier = Modifier
            .background(Color.LightGray)
            .padding(top = 70.dp)
            .border(
                BorderStroke(0.3.dp, Color.Black),
            )){

        items (films.value){ tv ->
            Card (onClick = { innernavController.navigate("DetailsSerie/" + tv.id) }){
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    AsyncImage(
                        model = ("https://image.tmdb.org/t/p/w780/" + tv.poster_path),
                        contentDescription = null,
                    )
                    Text(
                        text = tv.name,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}


@Composable
fun LayouthorizontalSerie(modifier: Modifier = Modifier, windowSizeClass: WindowSizeClass, innernavController :NavController) {

    val ViewModel : ViewModelserie = viewModel()
    val films = ViewModel.listtvs.collectAsState()

    LazyVerticalGrid( columns = GridCells.Fixed(3),
        modifier = Modifier
            .background(Color.LightGray)
            .padding(top = 70.dp)
            .border(
                BorderStroke(0.3.dp, Color.Black),
            )){
        items (films.value){ tv ->
            Card /*(onClick = { innernavController.navigate("DetailsSerie/" + tv.id) })*/{
                Column(verticalArrangement = Arrangement.Center) {
                    AsyncImage(
                        model = ("https://image.tmdb.org/t/p/w780/" + tv.poster_path),
                        contentDescription = null,
                        modifier = modifier
                            .size(200.dp)
                    )
                    Text(
                        text = tv.name,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,)
                }
            }

        }
    }
}