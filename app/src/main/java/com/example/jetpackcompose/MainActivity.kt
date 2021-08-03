package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

val customYellow = Color(0xFFF9E621)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                LogInScreen()
//                Surface(color = MaterialTheme.colors.background) {
//                    UserInput("Android")
//                }
            }
        }
    }
}

@Composable
fun LogInScreen() {
    Column {
        ToolBar()
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            UserInput()
            PasswordInput()
            ForgotPasswordText()
            LogInButton()
            LogInWithOtherAccounts()
            LogInWith(2, "Facebook")
            LogInWith(2, "Google")
            LogInWith(2, "Apple")
            SignInText()
        }
        InformationButton()
    }
}

@Composable
fun ToolBar() {
    TopAppBar(
        title = {
            Column(
                modifier = Modifier
                    .wrapContentHeight(CenterVertically)

                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = "makeA",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Log In", fontSize = 18.sp,
                    modifier = Modifier
                        .wrapContentHeight(CenterVertically)
                )
            }
        },
        backgroundColor = customYellow,
        modifier = Modifier.height(66.dp)
    )
}

@Composable
fun UserInput() {
    TextField(
        value = "",
        onValueChange = {
//
        },
        placeholder = { Text("Enter Email", color = Color.LightGray) },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
    )
}

@Composable
fun PasswordInput() {
    TextField(
        value = "",
        onValueChange = {
//
        },
        placeholder = { Text("Enter Password", color = Color.LightGray) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
    )
}

@Composable
fun ForgotPasswordText() {
    Text(
        "Click here if you forgot your password",
        style = TextStyle(textDecoration = TextDecoration.Underline),
        color = Color.Blue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        textAlign = TextAlign.End
    )
}

@Composable
fun LogInButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.LightGray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        shape = MaterialTheme.shapes.large
    ) {
        Text("Log In", color = Color.Black)
    }
}

@Composable
fun LogInWithOtherAccounts() {
    Text(
        "Log In With Other Accounts",
        color = Color.Gray,
        fontSize = 13.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 28.dp, bottom = 6.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun LogInWith(icon: Int, text: String) {
    Text(
        text,
        color = Color.Gray,
        fontSize = 14.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .border(
                border = BorderStroke(0.5.dp, color = Color.Black),
                shape = MaterialTheme.shapes.large
            )
            .absolutePadding(top = 10.dp, bottom = 10.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun SignInText() {
    Text(
        "Sign In Here",
        fontSize = 14.sp,
        style = TextStyle(textDecoration = TextDecoration.Underline),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun InformationButton() {
    Row(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentHeight(align = Alignment.Bottom)
            .background(color = customYellow)
            .padding(horizontal = 16.dp, vertical = 10.dp),
        Arrangement.Center
    ) {
        Text(
            text = "Contact  |  ",
            fontSize = 12.5.sp,
            modifier = Modifier.background(color = Color.Transparent)
        )
        Text(
            text = "Operating Company  |  ",
            fontSize = 12.5.sp,
            modifier = Modifier.background(color = Color.Transparent)
        )
        Text(
            text = "Terms of Service  |  ",
            fontSize = 12.5.sp,
            modifier = Modifier.background(color = Color.Transparent)
        )
        Text(
            text = "Policy",
            fontSize = 12.5.sp,
            modifier = Modifier.background(color = Color.Transparent)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        LogInScreen()
    }
}