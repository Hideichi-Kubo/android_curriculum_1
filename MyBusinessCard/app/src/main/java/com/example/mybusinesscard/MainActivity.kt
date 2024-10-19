package com.example.mybusinesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybusinesscard.ui.theme.MyBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun MyBusinessCardApp() {
    CardView(
        backgroundColor = Color(0xFFcae3c9)
    )
}

@Composable
fun CardView(backgroundColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        MyName(
            name = "Hideichi Kubo",
            title = "Android Developer Extraordinaire",
            logo = painterResource(R.drawable.android_logo),
            logoColor = Color(0xFF011934),
            stringColor = Color(0xFF495d2c)
        )
        MyContact(
            tel = "090-8436-2118",
            socialMediaHandle = "@Hideichi_Kubo",
            email = "unthought_known@outlook.jp",
            iconColor = Color(0xFF495d2c)
        )
    }
}

@Composable
fun MyName(name: String,
           title: String,
           logo: Painter,
           logoColor: Color,
           stringColor: Color,
           modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 220.dp)
    ) {
        Image(
            modifier = modifier
                .size(120.dp)
                .background(logoColor),
            painter = logo,
            contentDescription = null
        )
        Text(
            text = name,
            fontSize = 48.sp,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 16.dp)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = stringColor,
            modifier = modifier
        )
    }
}

@Composable
fun MyContact(
    tel: String,
    socialMediaHandle: String,
    email: String,
    iconColor: Color,
    modifier: Modifier = Modifier,

) {
    Column(
        modifier = modifier
            .padding(bottom = 40.dp)
    ) {
        Row(
            modifier = modifier
                .padding(12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier
                    .padding(end = 16.dp)
            )
            Text(
                text = tel
            )
        }
        Row(
            modifier = modifier
                .padding(12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier
                    .padding(end = 16.dp)
            )
            Text(
                text = socialMediaHandle
            )
        }
        Row(
            modifier = modifier
                .padding(12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier
                    .padding(end = 16.dp)
            )
            Text(
                text = email
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyBusinessCardPreview() {
    MyBusinessCardTheme {
        MyBusinessCardApp()
    }
}