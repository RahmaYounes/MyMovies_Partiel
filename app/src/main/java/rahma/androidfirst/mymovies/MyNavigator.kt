package rahma.androidfirst.mymovies


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
            composable("home") { MoviesScreen(windowSizeClass,innernavController) }
            composable("series") { SerieScreen(windowSizeClass,innernavController) }
            composable("actor") { ActorScreen(windowSizeClass) }
            composable("DescFILM/{filmId}") { Movies(windowSizeClass) }
            composable("DetailsSerie/{serieId}") { Series(windowSizeClass) }
        }
    }
}