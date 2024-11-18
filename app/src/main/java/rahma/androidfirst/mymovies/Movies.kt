package rahma.androidfirst.mymovies

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import rahma.androidfirst.mymovies.MainViewModel
import rahma.androidfirst.mymovies.ViewModeldescfilm
import java.time.format.TextStyle


@Composable
fun ScreenDescFILM(windowSizeClass: WindowSizeClass){
    val classeHauteur = windowSizeClass.heightSizeClass
    val classeLargeur = windowSizeClass.widthSizeClass

    when (classeLargeur) {
        WindowWidthSizeClass.Compact -> {
            LayoutverticalDescFilm(Modifier, windowSizeClass)
        }
        else -> {
            Row(Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically) {
                LayouthorizontalDescFilm(Modifier, windowSizeClass)
            }
        }
    }
}

@Composable
fun LayoutverticalDescFilm(modifier: Modifier = Modifier, windowSizeClass : WindowSizeClass) {
    val ViewModel: ViewModeldescfilm = viewModel()
    val detailsfilm = ViewModel.listDetailFilm.collectAsState()

    Column (
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally) {

        /*Titre du film*/
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center) {
            Text(
                text = detailsfilm.value.title,
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                color = Color.White
            )
        }

        /*Poster fond de toile*/
        Row(
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxSize()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.Center) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w780/" + detailsfilm.value.backdrop_path,
                contentDescription = "Poster fond de toile"
            )
        }

        /*Phrase d'acroche*/
        Row(
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxSize()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.Center){
            Text(
                text = detailsfilm.value.tagline,
                color = Color.White,
                fontSize = 20.sp
            )
        }

        /*Genre du film*/
        Row(
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxSize()
                .padding(vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            var genresTemp : String = ""
            detailsfilm.value.genres.forEach { genre -> genresTemp += genre.name + " - " }
            Text(
                text = genresTemp,
                color = Color.White,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 10.dp))
        }

        /*Affiche et synopsis*/
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)) {

            /*Affiche du filme*/
            Column (verticalArrangement = Arrangement.Center){
                AsyncImage( model = "https://image.tmdb.org/t/p/w780/" + detailsfilm.value.poster_path,
                    contentDescription = "Affiche du filme",
                    modifier = Modifier.size(150.dp))
            }

            /*Synopsis*/
            Column (
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = "Synopsis",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 15.dp, end = 30.dp))
                Text(
                    text = detailsfilm.value.overview,
                    modifier = Modifier.padding(end = 30.dp))
            }
        }

        /*Distribution*/
        Row (modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
            horizontalArrangement = Arrangement.Center) {
            Text(text = "Distribution",
                color = Color.White,
                fontSize = 20.sp)
        }

        Row(modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .background(Color.Black)
            .padding(16.dp)) {
            detailsfilm.value.credits.cast.forEach { cast ->
                Surface(
                    color = Color.Gray.copy(0.15f),
                    shape = MaterialTheme.shapes.medium,
                    onClick = {}) {
                    Column (modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally,){
                        AsyncImage(modifier = Modifier.size(300.dp),
                            model = "https://image.tmdb.org/t/p/w780/" + cast.profile_path,
                            contentDescription = null)
                        Text(text = cast.name, color = Color.White, fontSize = 15.sp, modifier = Modifier.padding(vertical = 8.dp))
                        Text(text = cast.character, color = Color.White, fontSize = 15.sp)
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}




@Composable
fun LayouthorizontalDescFilm(modifier: Modifier = Modifier,windowSizeClass : WindowSizeClass) {

    val ViewModel: ViewModeldescfilm = viewModel()
    val detailsfilm = ViewModel.listDetailFilm.collectAsState()

    Column (
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally) {

        /*Titre du film*/
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center) {
            Text(
                text = detailsfilm.value.title,
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                color = Color.White
            )
        }

        /*Poster fond de toile*/
        Row(
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxSize()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.Center) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w780/" + detailsfilm.value.backdrop_path,
                contentDescription = "Poster fond de toile"
            )
        }

        /*Phrase d'acroche*/
        Row(
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxSize()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.Center){
            Text(
                text = detailsfilm.value.tagline,
                color = Color.White,
                fontSize = 20.sp
            )
        }

        /*Genre du film*/
        Row(
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxSize()
                .padding(vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            var genresTemp : String = ""
            detailsfilm.value.genres.forEach { genre -> genresTemp += genre.name + " - " }
            Text(
                text = genresTemp,
                color = Color.White,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 10.dp))
        }

        /*Affiche et synopsis*/
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)) {

            /*Affiche du filme*/
            Column (verticalArrangement = Arrangement.Center){
                AsyncImage( model = "https://image.tmdb.org/t/p/w780/" + detailsfilm.value.poster_path,
                    contentDescription = "Affiche du filme",
                    modifier = Modifier.size(150.dp))
            }

            /*Synopsis*/
            Column (
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = "Synopsis",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 15.dp, end = 30.dp))
                Text(
                    text = detailsfilm.value.overview,
                    modifier = Modifier.padding(end = 30.dp))
            }
        }

        /*Distribution*/
        Row (modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
            horizontalArrangement = Arrangement.Center) {
            Text(text = "Distribution",
                color = Color.White,
                fontSize = 20.sp)
        }

        Row(modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .background(Color.Black)
            .padding(16.dp)) {
            detailsfilm.value.credits.cast.forEach { cast ->
                Surface(
                    color = Color.Gray.copy(0.15f),
                    shape = MaterialTheme.shapes.medium,
                    onClick = {}) {
                    Column (modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally,){
                        AsyncImage(modifier = Modifier.size(300.dp),
                            model = "https://image.tmdb.org/t/p/w780/" + cast.profile_path,
                            contentDescription = null)
                        Text(text = cast.name, color = Color.White, fontSize = 15.sp, modifier = Modifier.padding(vertical = 8.dp))
                        Text(text = cast.character, color = Color.White, fontSize = 15.sp)
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}