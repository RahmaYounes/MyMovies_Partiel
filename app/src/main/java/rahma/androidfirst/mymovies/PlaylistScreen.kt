
package rahma.androidfirst.mymovies

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import rahma.androidfirst.mymovies.ui.theme.CustomColor

@Composable
fun PlaylistScreen(windowSizeClass: WindowSizeClass, navController: NavController) {

    val  classeLargeur = windowSizeClass.widthSizeClass

            when (classeLargeur) {
                WindowWidthSizeClass.Compact -> {
                    LayoutVertical(modifier = Modifier, navController)
                }
                else -> {
                    LayoutHorizontal(modifier = Modifier, navController)
                }
            }

}

@Composable
fun Layoutvertical(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        PlaySection(modifier)

    }
}

@Composable
fun PlaySection(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Image principale circulaire
        AsyncImage(
            model = "file:///android_asset/image/2.jpg",
            contentDescription = "image partiel"
        )
        Spacer(modifier = Modifier.height(23.dp))


    }
}