package rahma.androidfirst.mymovies


import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import rahma.androidfirst.mymovies.R
import rahma.androidfirst.mymovies.MainViewModel
import rahma.androidfirst.mymovies.LayouthorizontalDescFilm
import rahma.androidfirst.mymovies.LayoutverticalDescFilm
import rahma.androidfirst.mymovies.ScreenACTOR
import rahma.androidfirst.mymovies.ScreenDescFILM
import rahma.androidfirst.mymovies.ScreenDescSERIE
import rahma.androidfirst.mymovies.ScreenFILM
import rahma.androidfirst.mymovies.ScreenSERIE

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNavigator(modifier: Modifier = Modifier, windowSizeClass : WindowSizeClass) {

    val innernavController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {


                BottomNavigationItem(
                    selected = false,
                    onClick = { innernavController.navigate("home") },
                    icon = { Icon(Icons.Filled.Send, contentDescription = null) },
                    label = { Text(text = "Films") }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { innernavController.navigate("series") },
                    icon = {Icon(Icons.Filled.PlayArrow, contentDescription = null) },
                    label = { Text(text = "Series") }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { innernavController.navigate("actor") },
                    icon = { Icon(Icons.Filled.Star, contentDescription = null)  },
                    label = { Text(text = "Actors") }
                )
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = innernavController,
            startDestination = "home",
            Modifier.padding(innerPadding)
        ) {
            composable("home") { ScreenFILM(windowSizeClass,innernavController) }
            composable("series") { ScreenSERIE(windowSizeClass,innernavController) }
            composable("actor") { ScreenACTOR(windowSizeClass) }
            composable("DescFILM/{filmId}") { ScreenDescFILM(windowSizeClass) }
            composable("DetailsSerie/{serieId}") { ScreenDescSERIE(windowSizeClass) }
        }
    }
}