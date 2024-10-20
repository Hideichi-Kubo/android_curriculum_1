package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableIntStateOf(1) }
    var squeezeCount by remember { mutableIntStateOf(0) }

    LemonadeHeader(title = stringResource(R.string.app_name))

    when (currentStep) {
        1 -> {
            LemonTextAndImage(
                lemonPainter = painterResource(R.drawable.lemon_tree),
                lemonContentDescription = stringResource(R.string.lemon_tree_content_description),
                textLabel = stringResource(R.string.lemon_tree_text),
                onImageClick = {
                    currentStep = 2
                    squeezeCount = (2..4).random()
                }
            )
        }
        2 -> {
            LemonTextAndImage(
                lemonPainter = painterResource(R.drawable.lemon_squeeze),
                lemonContentDescription = stringResource(R.string.lemon_squeeze_content_description),
                textLabel = stringResource(R.string.lemon_squeeze_text),
                onImageClick = {
                    squeezeCount--
                    if (squeezeCount == 0) {
                        currentStep = 3
                    }
                }
            )
        }
        3 -> {
            LemonTextAndImage(
                lemonPainter = painterResource(R.drawable.lemon_drink),
                lemonContentDescription = stringResource(R.string.lemon_drink_content_description),
                textLabel = stringResource(R.string.lemon_drink_text),
                onImageClick = {
                    currentStep = 4
                }
            )
        }
        4 -> {
            LemonTextAndImage(
                lemonPainter = painterResource(R.drawable.lemon_restart),
                lemonContentDescription = stringResource(R.string.lemon_restart_content_description),
                textLabel = stringResource(R.string.lemon_restart_text),
                onImageClick = {
                    currentStep = 1
                }
            )
        }
    }
}

@Composable
fun LemonTextAndImage(
    lemonPainter: Painter,
    lemonContentDescription: String,
    textLabel: String,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFbeecd3)
            ),
            modifier = Modifier
                .size(200.dp)
                .border(
                    width = 2.dp,
                    Color(0xFF69cdd8),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Image(
                painter = lemonPainter,
                contentDescription = lemonContentDescription,
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = textLabel,
            fontSize = 18.sp
        )
    }
}

@Composable
fun LemonadeHeader(
    title: String
    ) {
    Surface(
        color = Color(0xFFfada0d)
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonTextAndImagePreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}