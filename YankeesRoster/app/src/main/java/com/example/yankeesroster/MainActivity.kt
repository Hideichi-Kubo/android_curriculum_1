package com.example.yankeesroster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.yankeesroster.model.PlayerRepository
import com.example.yankeesroster.ui.theme.YankeesRosterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YankeesRosterTheme {
                YankeesRosterApp()
            }
        }
    }
}

@Composable
fun YankeesRosterApp() {
    Scaffold(
        topBar = {
            YankeesRosterTopAppBar()
        }
    ) { paddingValues ->
        val players = PlayerRepository.players
        PlayerCardList(players = players, contentPadding = paddingValues )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YankeesRosterTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun YankeesRosterAppPreview() {
    YankeesRosterTheme {
        YankeesRosterApp()
    }
}

