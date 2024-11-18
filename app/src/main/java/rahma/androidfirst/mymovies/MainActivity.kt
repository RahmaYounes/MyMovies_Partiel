package rahma.androidfirst.mymovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import rahma.androidfirst.mymovies.ScreenFILM
import rahma.androidfirst.mymovies.MyNavigator
import rahma.androidfirst.mymovies.Screen
import rahma.androidfirst.mymovies.ui.theme.PremiereApplicationMonProfilTheme




class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            PremiereApplicationMonProfilTheme {
                // A surface container using the 'background' color from the theme
            }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val windowSizeClass = calculateWindowSizeClass(this)
                val navController = rememberNavController()
                NavHost(navController = navController ,startDestination = "screen") {
                    composable("screen")
                    { Screen(windowSizeClass = windowSizeClass, navController = navController) }
                    composable("navigation")
                    { MyNavigator(windowSizeClass = windowSizeClass) }
                }
            }
        }
    }
}