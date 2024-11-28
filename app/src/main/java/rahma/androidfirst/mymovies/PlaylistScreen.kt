
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
    val classeLargeur = windowSizeClass.widthSizeClass

    when (classeLargeur) {
        WindowWidthSizeClass.Compact -> {
            Layoutvertical(modifier = Modifier, navController)
        }
        else -> {
            Layouthorizontal(modifier = Modifier, navController)
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
        PlaySectionVertical(modifier)
    }
}

@Composable
fun Layouthorizontal(modifier: Modifier = Modifier, navController: NavController) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PlaySectionHorizontal(modifier)
    }
}

@Composable
fun PlaySectionVertical(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Fav'app",
            modifier = modifier,
            fontFamily = FontFamily.SansSerif,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(50.dp))

        AsyncImage(
            model = "file:///android_asset/1.jpg",
            contentDescription = "Image 1",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "3 Gymnopédies: No. 1, Lent et douloureux",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))

        AsyncImage(
            model = "file:///android_asset/2.jpg",
            contentDescription = "Image 2",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Bach, JS: Cello Suite No. 1 in G Major, BWV 1007: I. Prélude",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PlaySectionHorizontal(modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        // Première image avec titre
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Fav'app",
                modifier = modifier,
                fontFamily = FontFamily.SansSerif,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(50.dp))

            AsyncImage(
                model = "file:///android_asset/1.jpg", // Chemin correct
                contentDescription = "Image 1",
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "3 Gymnopédies: No. 1, Lent et douloureux",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = "file:///android_asset/2.jpg",
                contentDescription = "Image 2",
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Bach, JS: Cello Suite No. 1 in G Major, BWV 1007: I. Prélude",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = "file:///android_asset/3.jpg",
                contentDescription = "Image 3",
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Beethoven: Piano Sonata No. 14 in C-Sharp Minor, Op. 27 No. 2 \"Moonlight Sonata\": I. Adagio sostenuto",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}