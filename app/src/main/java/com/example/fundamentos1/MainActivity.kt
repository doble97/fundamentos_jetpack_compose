package com.example.fundamentos1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fundamentos1.entidades.Usuario
import com.example.fundamentos1.ui.theme.Fundamentos1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Fundamentos1Theme() {
                Column {
                    TopAppBar(title = {
                        Text(text = "Vocabulario")
                    })
                    CardUser(Usuario("Jorge", "jorge@gmail.com"))
                    Text(text = "---------------------")
                }
            }

        }
    }
}

@Composable
fun CardUser(user:Usuario) {
    Row (modifier = Modifier
        .padding(8.dp)) {
       Image(painter = painterResource(id = R.drawable.imagen_avatar), contentDescription = "Imagen de un avatar",
           modifier = Modifier
               .size(40.dp)
               .clip(CircleShape)
               .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
           )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Row{
                Text(text = "Nombre de usuario: ", style = MaterialTheme.typography.subtitle1)
                Text(text = user.username, color=MaterialTheme.colors.secondaryVariant,
                style=MaterialTheme.typography.subtitle2)
            }
            Spacer(modifier = Modifier.height(4.dp))
            //elevation en surface sirve para la sombra. En shape se puede poner CircleShape.
            Surface(shape = MaterialTheme.shapes.medium, elevation = 18.dp){
                Row {
                    Text(text = "Email de usuario: ", style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier.padding(all=4.dp)
                        )
                    Text(text = user.email, color=MaterialTheme.colors.secondaryVariant,
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier.padding(all = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview(name="Light mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    Fundamentos1Theme {
        CardUser(Usuario("Jorge"))
    }
}