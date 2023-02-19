package ru.dmitryskor.rickandmortyapi.core.ui.error

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.dmitryskor.rickandmortyapi.R

/**
 * Created by Dmitry Skorodumov on 19.02.2023
 */

@Composable
fun ErrorView(
    message: String,
    modifier: Modifier = Modifier,
    onClickRetry: () -> Unit
) {
    Column(
        modifier = modifier.padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${stringResource(id = R.string.error_with_description)}: $message",
            color = colorResource(id = R.color.neutral_case),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedButton(onClick = onClickRetry) {
            Text(text = stringResource(id = R.string.try_again))
        }
    }
}