package rahma.androidfirst.mymovies

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import rahma.androidfirst.mymovies.ui.theme.Purple40

@Composable
fun ProfileScreen(windowSizeClass: WindowSizeClass, navController: NavController) {
    val classeLargeur = windowSizeClass.widthSizeClass

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
fun LayoutVertical(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        ProfileSection(modifier)
        ContactSection(modifier)
        StartButton(navController)
    }
}

@Composable
fun LayoutHorizontal(modifier: Modifier = Modifier, navController: NavController) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Colonne de gauche : image et infos personnelles
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {
            ProfileSection(modifier)
        }

        // Colonne de droite : icônes, textes associés et bouton
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Centré horizontalement
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {
            ContactSection(modifier)
            Spacer(modifier = Modifier.height(16.dp))
            StartButton(navController) // Bouton centré
        }
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Image principale circulaire
        Image(
            painter = painterResource(id = R.drawable.image1),
            contentDescription = "Moi",
            modifier = modifier
                .size(160.dp)
                .clip(CircleShape)
                .border(BorderStroke(1.dp, Color.Gray), CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(23.dp))
        Text(
            text = "Rahma Ben Younes",
            modifier = modifier,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Étudiante en 4ème année en alternance",
            modifier = modifier,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Data Analyst - Pierre Fabre",
            modifier = modifier,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic
        )
    }
}

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.padding(top = 40.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.mail),
                contentDescription = "Logo Gmail",
                modifier = modifier
                    .size(35.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "rahmabenyounes@yahoo.com",
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.linkedin),
                contentDescription = "Logo LinkedIn",
                modifier = modifier
                    .size(35.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .border(BorderStroke(1.dp, Color.Blue), RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "www.linkedin.com/in/rahma-younes",
                fontSize = 12.sp,
                modifier = Modifier.clickable {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://fr.linkedin.com/in/rahma-ben-younes-a77b97222")
                    )
                    context.startActivity(intent)
                },
                color = Color.Blue
            )
        }
    }
}

@Composable
fun StartButton(navController: NavController) {
    Box(contentAlignment = Alignment.Center) {
        Button(
            onClick = { navController.navigate("navigation") },
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Purple40 // Bouton bleu
            )
        ) {
            Text(text = "Démarrer", color = Color.White) // Texte blanc pour contraste
        }
    }
}
