package com.example.fundamentos1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fundamentos1.entidades.Usuario
import com.example.fundamentos1.fake_data.Mensajes
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
                    CardUser(Usuario("Jorge", email ="jorge@gmail.com"))
                    Text(text = "---------------------")
                    Conversation(Mensajes.createMsgs())
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

@Composable
fun MessageCard(user:Usuario) {
    Row (modifier = Modifier.padding(8.dp)){
        Image(painter = painterResource(id = R.drawable.imagen_avatar), contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )
        Spacer(modifier = Modifier.width(4.dp))
        //Vamos a almacenar un valor que usará la UI por lo que cualquier cambio en este queremos saberlo
        var isExpanded by remember {mutableStateOf(false)}
        //añadiendo un cambio de color al hacer click
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
        )
        //Ahora toca añadir el click para el elemento mediante el modifier
        Column(modifier=Modifier.clickable { isExpanded= !isExpanded }) {
            Text(text = user.username, style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.secondaryVariant
                )
            Spacer(modifier = Modifier.height(8.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp,
                color=surfaceColor, modifier = Modifier.animateContentSize().padding(1.dp)
                ){
                Text(text = user.description, style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if(isExpanded) Int.MAX_VALUE else 1
                    )
            }
        }
    }
}
@Composable
fun Conversation(messages:List<Usuario>) {
    LazyColumn{
        items(messages){message->
            MessageCard(message)
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
        Conversation(Mensajes.createMsgs())
    }
}