package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroRepository
import com.example.superheroes.model.HeroRepository.heroes
import com.example.superheroes.ui.theme.Shapes
import com.example.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroCardList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = contentPadding
    ) {
        items(heroes) { hero ->
            HeroCard(
                hero = hero,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun HeroCard(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            HeroDescription(
                hero = hero,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .weight(1f)
            )
            Box(
                modifier = Modifier
                    .size(72.dp)
            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .clip(Shapes.small)
                )
            }
        }
    }
}

@Composable
fun HeroDescription(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(72.dp)
    ) {
        Text(
            text = stringResource(hero.nameRes),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(hero.descriptionRes),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeroScreenPreview() {
    SuperheroesTheme {
        HeroCardList(
            heroes = HeroRepository.heroes
        )
    }
}