package rahma.androidfirst.mymovies

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNavigator(modifier: Modifier = Modifier, windowSizeClass: WindowSizeClass) {

    val innernavController = rememberNavController()
    Scaffold(
        bottomBar = {
            Surface(
                shape = RoundedCornerShape(topStart = 11.dp, topEnd = 5.dp),
                tonalElevation = 8.dp,
                color = Color.White,
                contentColor = Color.Gray
            ) {
                NavigationBar(
                    containerColor = Color.Transparent,
                    contentColor = Color.Gray
                ) {
                    NavigationBarItem(
                        selected = false,
                        onClick = { innernavController.navigate("home") },
                        icon = { Icon(Icons.Filled.Send, contentDescription = null, modifier = Modifier.padding(bottom = 4.dp)) },
                        label = { Text(text = "Films") },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Cyan,
                            unselectedIconColor = Color.Gray,
                            selectedTextColor = Color.Cyan,
                            unselectedTextColor = Color.Gray
                        )
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = { innernavController.navigate("series") },
                        icon = { Icon(Icons.Filled.PlayArrow, contentDescription = null, modifier = Modifier.padding(bottom = 3.dp)) },
                        label = { Text(text = "Series") },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Cyan,
                            unselectedIconColor = Color.Gray,
                            selectedTextColor = Color.Cyan,
                            unselectedTextColor = Color.Gray
                        )
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = { innernavController.navigate("actor") },
                        icon = { Icon(Icons.Filled.Star, contentDescription = null, modifier = Modifier.padding(bottom = 4.dp)) },
                        label = { Text(text = "Actors") },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Cyan,
                            unselectedIconColor = Color.Gray,
                            selectedTextColor = Color.Cyan,
                            unselectedTextColor = Color.Gray
                        )
                    )
                }
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = innernavController,
            startDestination = "home",
            Modifier.padding(innerPadding)
        ) {
            composable("home") { MoviesScreen(windowSizeClass, innernavController) }
            composable("series") { SerieScreen(windowSizeClass, innernavController) }
            composable("actor") { ActorScreen(windowSizeClass, innernavController) }
            composable("DescFILM/{filmId}") { Movies(windowSizeClass) }
            composable("DetailsSerie/{serieId}") { Series(windowSizeClass) }
        }
    }
}