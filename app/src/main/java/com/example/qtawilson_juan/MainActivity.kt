package com.example.qtawilson_juan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qtawilson_juan.ui.theme.QTAWILSON_JUANTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QTAWILSON_JUANTheme {
                val navController = rememberNavController()
                MainScreen(navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dos mitades") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF00D084), // Verde claro
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF00D084) // Verde claro
            ) {
                NavigationBarItem(
                    selected = navController.currentBackStackEntry?.destination?.route == "dos_mitades",
                    onClick = { navController.navigate("dos_mitades") },
                    label = { Text("Dos mitades") },
                    icon = {}
                )
                NavigationBarItem(
                    selected = navController.currentBackStackEntry?.destination?.route == "dos_palabras",
                    onClick = { navController.navigate("dos_palabras") },
                    label = { Text("Dos palabras") },
                    icon = {}
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    label = { Text("Quitar fragmento") },
                    icon = {}
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "dos_mitades",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("dos_mitades") { DosMitadesContent() }
            composable("dos_palabras") { DosPalabrasContent() }
        }
    }
}

@Composable
fun DosMitadesContent() {
    var inputText by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hola alejing@gmail.com",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Te voy a ayudar a solucionar el problema de las 2 mitades.",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "1. Ingresa una cadena de caracteres.\n" +
                    "2. Te ayudaré a cortar la cadena en dos partes \"iguales\" (si la longitud de la cadena es impar, colocaré el carácter central en la primera cadena, de modo que la primera cadena contenga un carácter más que la segunda).\n" +
                    "3. Luego imprimiré la nueva cadena en una sola fila con la primera y la segunda mitad intercambiadas (la segunda mitad es la primera y la primera mitad es la segunda).",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Black
            ),
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        BasicTextField(
            value = inputText,
            onValueChange = { inputText = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            textStyle = TextStyle(fontSize = 18.sp, color = Color.Black)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Aquí añadimos la funcionalidad posteriormente */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00D084)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Solucionar",
                style = TextStyle(fontSize = 18.sp, color = Color.White)
            )
        }
    }
}

@Composable
fun DosPalabrasContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Esta es la pantalla de Dos Palabras",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Aquí se implementará la funcionalidad para dos palabras.",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            ),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DosMitadesPreview() {
    QTAWILSON_JUANTheme {
        val navController = rememberNavController()
        MainScreen(navController)
    }
}
