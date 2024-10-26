package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var artNumber by remember { mutableIntStateOf(1) }

    when (artNumber) {
        1 -> {
            ArtSpaceView(
                artImage = R.drawable.art_space_image_1,
                artTitle = R.string.art_space_title_1,
                artist = R.string.art_space_artist_1,
                artRelease = R.string.art_space_release_1,
                onPreviousClick = { artNumber = 3 },
                onNextClick = { artNumber = 2 }
            )
        }
        2 -> {
            ArtSpaceView(
                artImage = R.drawable.art_space_image_2,
                artTitle = R.string.art_space_title_2,
                artist = R.string.art_space_artist_2,
                artRelease = R.string.art_space_release_2,
                onPreviousClick = { artNumber = 1 },
                onNextClick = { artNumber = 3 }
            )
        }
        3 -> {
            ArtSpaceView(
                artImage = R.drawable.art_space_image_3,
                artTitle = R.string.art_space_title_3,
                artist = R.string.art_space_artist_3,
                artRelease = R.string.art_space_release_3,
                onPreviousClick = { artNumber = 2 },
                onNextClick = { artNumber = 1 }
            )
        }
    }
}

@Composable
fun ArtSpaceView(
    @DrawableRes artImage: Int,
    @StringRes artTitle: Int,
    @StringRes artist: Int,
    @StringRes artRelease: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ArtSpaceDisplay(
            artImage = artImage,
            modifier = Modifier
                .padding(32.dp)
        )
        ArtSpaceDescription(
            artTitle = artTitle,
            artist = artist,
            artRelease = artRelease,
        )
        ArtSpaceButton(
            onPreviousClick = onPreviousClick,
            onNextClick = onNextClick,
        )
    }
}

@Composable
fun ArtSpaceDisplay(
    @DrawableRes artImage: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .wrapContentHeight()
            .shadow(elevation = 12.dp)
    ) {
        Image(
            painter = painterResource(artImage),
            contentDescription = null,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
fun ArtSpaceDescription(
    @StringRes artTitle: Int,
    @StringRes artist: Int,
    @StringRes artRelease: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .wrapContentHeight()
            .padding(24.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(artTitle),
                fontSize = 24.sp
            )
            Row {
                Text(
                    text = stringResource(artist),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(artRelease),
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun ArtSpaceButton(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(28.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onPreviousClick,

            ) {
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier)
        Button(
            onClick = onNextClick,
            ) {
            Text(text = "Next")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceView(
            artImage = R.drawable.art_space_image_1,
            artTitle = R.string.art_space_title_1,
            artist = R.string.art_space_artist_1,
            artRelease = R.string.art_space_release_1,
            onPreviousClick = {},
            onNextClick = {}
        )
    }
}