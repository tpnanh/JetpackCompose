package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

val customYellow = Color(0xFFF9E621)
val customBlue = Color(0xFF0AA9F4)
val customGrayButton = Color(0xFFD3D3D3)
val customGrayHiddenText = Color(0xFFAFAFAF)
val customGrayText = Color(0xFF555555)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                LogInScreen()
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
            LogInWith(R.drawable.facebook, stringResource(R.string.facebook))
            LogInWith(R.drawable.google, stringResource(R.string.google))
            LogInWith(R.drawable.apple, stringResource(R.string.apple))
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
                    text = stringResource(R.string.makeA),
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.log_in),
                    fontSize = 18.sp,
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
        placeholder = { Text(stringResource(R.string.enter_email), color = customGrayHiddenText) },
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
        placeholder = {
            Text(
                stringResource(R.string.enter_password),
                color = customGrayHiddenText
            )
        },
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
        stringResource(R.string.click_here_if_you_forgot_your_password),
        style = TextStyle(textDecoration = TextDecoration.Underline),
        color = customBlue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        textAlign = TextAlign.End,
        fontSize = 12.sp
    )
}

@Composable
fun LogInButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = customGrayButton
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        shape = MaterialTheme.shapes.large
    ) {
        Text(text = stringResource(R.string.log_in), color = Color.Black)
    }
}

@Composable
fun LogInWithOtherAccounts() {
    Text(
        stringResource(R.string.log_in_with_others_account),
        color = Color.Gray,
        fontSize = 12.sp,
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
        stringResource(R.string.sign_in_here),
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
            .padding(horizontal = 10.dp, vertical = 10.dp),
        Arrangement.Center
    ) {
        InformationButton(stringResource(R.string.contact))
        VerticleLine()
        InformationButton(stringResource(R.string.operating_company))
        VerticleLine()
        InformationButton(stringResource(R.string.terms_of_service))
        VerticleLine()
        InformationButton(stringResource(R.string.policy))
    }
}

@Composable
fun InformationButton(text: String) {
    Text(
        text = text,
        fontSize = 12.sp,
        modifier = Modifier.background(color = Color.Transparent),
        color = customGrayText
    )
}

@Composable
fun VerticleLine() {
    Text(
        text = "  |  ",
        fontSize = 12.5.sp,
        modifier = Modifier.background(color = Color.Transparent),
        color = customGrayText
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        LogInScreen()
    }
}