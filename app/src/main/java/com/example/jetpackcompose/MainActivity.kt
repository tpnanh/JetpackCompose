package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

val customYellow = Color(0xFFF9E621)
val customBlue = Color(0xFF1ac6ff)

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
            LogInWith(R.drawable.facebook, "Facebook")
            LogInWith(R.drawable.google, "Google")
            LogInWith(R.drawable.apple, "Apple")
        }
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            SignInText()
            InformationButton()
        }
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
    val emailText = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = emailText.value,
        onValueChange = {
            emailText.value = it
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
    val passwordText = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = passwordText.value,
        onValueChange = {
            passwordText.value = it
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
        color = customBlue,
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
    Box(
        Modifier
            .padding(top = 10.dp)
            .border(
                border = BorderStroke(0.5.dp, color = Color.Black),
                shape = MaterialTheme.shapes.large
            )
            .absolutePadding(top = 10.dp, bottom = 10.dp)
            .fillMaxWidth(),
        contentAlignment = Center
    ) {
        Row(Modifier.wrapContentWidth()) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text,
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 14.dp)
            )
        }
    }
}

@Composable
fun SignInText() {
    Text(
        "Sign In Here",
        fontSize = 14.sp,
        style = TextStyle(textDecoration = TextDecoration.Underline),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentHeight(CenterVertically)
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
        ClickableText(
            text = AnnotatedString("Contact"), onClick = {},
            style = TextStyle(fontSize = 12.5.sp),
            modifier = Modifier.background(color = Color.Transparent)
        )
        VerticleLine()
        ClickableText(
            text = AnnotatedString("Operating Company"), onClick = {},
            style = TextStyle(fontSize = 12.5.sp),
            modifier = Modifier.background(color = Color.Transparent)
        )
        VerticleLine()
        ClickableText(
            text = AnnotatedString("Terms of Service"), onClick = {},
            style = TextStyle(fontSize = 12.5.sp),
            modifier = Modifier.background(color = Color.Transparent)
        )
        VerticleLine()
        ClickableText(
            text = AnnotatedString("Policy"), onClick = {},
            style = TextStyle(fontSize = 12.5.sp),
            modifier = Modifier.background(color = Color.Transparent)
        )
    }
}

@Composable
fun VerticleLine() {
    Text(
        text = "  |  ",
        fontSize = 12.5.sp,
        modifier = Modifier.background(color = Color.Transparent)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        LogInScreen()
    }
}