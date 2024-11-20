package rahma.androidfirst.mymovies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    // Padding appliqué autour de la SearchBar entière
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 23.dp, bottom = 3.dp) // Padding avant et après la SearchBar entière
    ) {
        TextField(
            value = query,
            onValueChange = onQueryChange,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search1), // Icône PNG
                    contentDescription = "Search Icon",
                    tint = Color.Unspecified, // Garder les couleurs d'origine de l'icône PNG
                    modifier = Modifier
                        .size(24.dp) // Taille de l'icône
                )
            },
            placeholder = {
                Text(
                    text = "Search movies...",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF1F1F1), // Fond gris clair
                    shape = CutCornerShape(topStart = 12.dp, topEnd = 12.dp) // Coins arrondis uniquement en haut
                ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Blue,
                focusedIndicatorColor = Color.Blue, // Ligne bleue au focus
                unfocusedIndicatorColor = Color.Blue, // Ligne bleue au non-focus
                containerColor = Color.Transparent // Retirer le fond par défaut
            )
        )
    }
}







/*

package rahma.androidfirst.mymovies

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        label = { Text("Search") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Blue,
            unfocusedIndicatorColor = Color.Blue
        )
    )
}
*/