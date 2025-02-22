package com.yasir.buttoncomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yasir.buttoncomponents.ui.theme.ButtonComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ButtonComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Components(
                        //name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Components(modifier: Modifier = Modifier) {

    val myButtonBackgroundColor = remember {
        mutableStateOf(Color.Red)
    }

    val myButtonText = remember {
        mutableStateOf("Do Your Magic")
    }

    val myButtonTextColor = remember {
        mutableStateOf(Color.White)
    }

    val myText = remember {
        mutableStateOf("How World!")
    }

    val myTextColor = remember {
        mutableStateOf(Color.Black)
    }

    val buttonStatus = remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = myText.value,
            color = myTextColor.value,
            fontSize = 24.sp,
            modifier = Modifier
                .background(Color.Red)
                .padding(10.dp)
        )

        Spacer(modifier = Modifier.size(30.dp))

        Button(
            onClick = {

                if (buttonStatus.value) {
                    myButtonBackgroundColor.value = Color.Black
                    myButtonText.value = "I like JPC"
                    myButtonTextColor.value = Color.Red
                    myText.value = "Hello Compose"
                    myTextColor.value = Color.White

                    buttonStatus.value = false
                } else {
                    myButtonBackgroundColor.value = Color.Red
                    myButtonText.value = "Do Your Magic"
                    myButtonTextColor.value = Color.White
                    myText.value = "Hello World"
                    myTextColor.value = Color.Black

                    buttonStatus.value = true
                }
                myButtonBackgroundColor.value = Color.Black
                myButtonText.value = "I like JPC"
                myButtonTextColor.value = Color.Red
                myText.value = "Hello Compose"
                myTextColor.value = Color.White
            },
            modifier = Modifier.size(250.dp, 60.dp),
            colors = ButtonDefaults.buttonColors(myButtonBackgroundColor.value),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, Color.Black)
        ) {
            if (buttonStatus.value) {
                Text(
                    text = myButtonText.value,
                    color = myButtonTextColor.value,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    ButtonComponentsTheme {
        Components()
    }
}