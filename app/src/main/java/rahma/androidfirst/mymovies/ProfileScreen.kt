package rahma.androidfirst.mymovies

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import rahma.androidfirst.mymovies.R

@Composable
fun Screen(windowSizeClass: WindowSizeClass, navController: NavController){
    val classeHauteur = windowSizeClass.heightSizeClass
    val classeLargeur = windowSizeClass.widthSizeClass

    when (classeLargeur) {
        WindowWidthSizeClass.Compact -> {
            Layoutvertical(modifier = Modifier,navController)
        }
        else -> {
            Row(
                Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically) {
                Layouthorizontal(modifier = Modifier,navController)
            }
        }
    }
}


@Composable
fun Layoutvertical(modifier: Modifier = Modifier,navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){
        Box(contentAlignment = Alignment.Center) {
            Column {
                Image(
                    painterResource(id = R.drawable.image1),
                    contentDescription = "moi",
                    modifier = modifier
                        .size(160.dp)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(4.dp, Color.DarkGray),
                            CircleShape
                        ),
                    contentScale = ContentScale.Crop

                )
                Text(
                    text = "Rahma Ben Younes", modifier = modifier,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Etudiante ingénieur", modifier = modifier,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "ISIS Castres", modifier = modifier,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic
                )
            }
        }

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.padding(top = 40.dp )){
            Column (horizontalAlignment = Alignment.Start){
                Row (verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painterResource(id = R.drawable.mail),
                        contentDescription = "Logo_gmail",
                        modifier = modifier
                            .size(35.dp)
                            .clip(CircleShape)
                            .border(
                                BorderStroke(1.dp, Color.Red),
                                CircleShape
                            ),
                        contentScale = ContentScale.Crop
                    )
                    Text(text =" rahma.younes111@gmail.com",
                        fontSize = 12.sp)
                }

                Row (verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painterResource(id = R.drawable.linkedin),
                        contentDescription = "Logo_linkedin",
                        modifier = modifier
                            .size(35.dp)
                            .clip(CircleShape)
                            .border(
                                BorderStroke(1.dp, Color.Blue),
                                CircleShape
                            ),
                        contentScale = ContentScale.Crop
                    )
                    Text(text =" www.linkedin.com/in/rahma-younes",
                        fontSize = 12.sp )
                }
            }

        }
        Box(contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .padding(top = 70.dp)
                .border(
                    BorderStroke(6.dp, Color.Green),
                    CircleShape
                )){
            Button(onClick = { navController.navigate("navigation") }) {
                Text(text = "Démarrer")
            }
        }
    }
}


@Composable
fun Layouthorizontal(modifier: Modifier = Modifier, navController: NavController) {
    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){
        Box(contentAlignment = Alignment.Center) {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    painterResource(id = R.drawable.image1),
                    contentDescription = "moi",
                    modifier = modifier
                        .size(160.dp)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(4.dp, Color.DarkGray),
                            CircleShape
                        ),
                    contentScale = ContentScale.Crop

                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Rahma Ben Younes", modifier = modifier,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Etudiante ingénieur", modifier = modifier,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "ISIS Castres", modifier = modifier,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic
                )
            }
        }

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.padding(top = 40.dp )){
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Row (verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painterResource(id = R.drawable.mail),
                        contentDescription = "Logo_gmail",
                        modifier = modifier
                            .size(35.dp)
                            .clip(CircleShape)
                            .border(
                                BorderStroke(1.dp, Color.Red),
                                CircleShape
                            ),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text =" rahma.younes111@gmail.com",
                        fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row (verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painterResource(id = R.drawable.linkedin),
                        contentDescription = "Logo_linkedin",
                        modifier = modifier
                            .size(35.dp)
                            .clip(CircleShape)
                            .border(
                                BorderStroke(1.dp, Color.Blue),
                                CircleShape
                            ),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text =" www.linkedin.com/in/rahma-younes",
                        fontSize = 12.sp )
                }
            }

        }
        Box(
            modifier = Modifier
                .padding(top = 70.dp)
                .border(
                    BorderStroke(6.dp, Color.Green),
                    CircleShape
                )){
            Button(onClick = { navController.navigate("navigation") }) {
                Text(text = "Démarrer")
            }
        }
    }
}