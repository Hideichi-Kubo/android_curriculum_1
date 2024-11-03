package com.example.yankeesroster


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yankeesroster.model.Player
import com.example.yankeesroster.model.PlayerRepository
import com.example.yankeesroster.ui.theme.YankeesRosterTheme

@Composable
fun PlayerCardList(
    players: List<Player>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = contentPadding
    ) {
        items(players) { player ->
            PlayerCard(player = player)
        }
    }
}

@Composable
fun PlayerCard(
    player: Player,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium))
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .height(116.dp)
            ) {
                Image(
                    painter = painterResource(player.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                )
                Column(
                    modifier = Modifier
                        .padding(start = dimensionResource(R.dimen.padding_small))
                ) {
                    Spacer(modifier = modifier.weight(1f))
                    Text(
                        text = stringResource(player.nameRes),
                        style = MaterialTheme.typography.displaySmall,
                    )
                    Spacer(modifier = modifier.weight(1f))
                }
                Spacer(modifier = Modifier.weight(1f))
                PlayerDescriptionButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }
            if (expanded) {
                Text(
                    text = stringResource(player.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(top = dimensionResource(R.dimen.padding_medium))
                )
            }
        }
    }
}

@Composable
fun PlayerDescriptionButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = onClick,
            modifier = modifier
        ) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = stringResource(R.string.expand_button_content_description),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerCardPreview() {
    YankeesRosterTheme(darkTheme = false) {
        PlayerCardList(
            players = PlayerRepository.players
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerCardDarkThemePreview() {
    YankeesRosterTheme(darkTheme = true) {
        PlayerCardList(
            players = PlayerRepository.players
        )
    }
}