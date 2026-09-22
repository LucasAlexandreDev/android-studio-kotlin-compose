package com.example.kotlin_compose

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlin_compose.ui.theme.KotlincomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlincomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(){

    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .padding(32.dp)
        .fillMaxWidth()) {

        OutlinedTextField(modifier = Modifier.fillMaxWidth(),

            value = text,
            onValueChange = {text = it},

            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
            ),

            placeholder = {
                Text(text = "O que você está procurando")
            },

            trailingIcon = {

                Icon(
                    painter = painterResource(R.drawable.baseline_content_paste_search_24),
                    contentDescription = "Campo de Busca"
                )
            }
        )
    }
}