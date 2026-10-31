package dev.k.kotea_sample.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.k.kotea_sample.R
import dev.k.kotea_sample.core.ui.theme.KoteasampleTheme

@Composable
internal fun MainScreen(
    state: MainUiState,
    onLoadDataClick: () -> Unit,
    onThrowErrorClick: () -> Unit,
) {
    MainScreenUi(
        state = state,
        onLoadDataClick = onLoadDataClick,
        onThrowErrorClick = onThrowErrorClick,
    )
}

@Composable
private fun MainScreenUi(
    state: MainUiState,
    onLoadDataClick: () -> Unit,
    onThrowErrorClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            Text(
                text = stringResource(R.string.main_title),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .padding(4.dp)
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            item {
                DefaultButton(text = stringResource(R.string.main_load_data)) {
                    onLoadDataClick()
                }
            }
            item {
                DefaultButton(text = stringResource(R.string.main_throw_error)) {
                    onThrowErrorClick()
                }
            }
            item {
                Text(
                    text = "Data is ${state.dataText ?: "null"}",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}

@Composable
private fun DefaultButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(12.dp, 0.dp)
            .fillMaxSize(),
        shape = RoundedCornerShape(8.dp),
        colors = buttonColors(
            containerColor = MaterialTheme.colorScheme.onBackground,
            contentColor = MaterialTheme.colorScheme.background,
        ),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenUiPreview() {
    KoteasampleTheme {
        MainScreenUi(MainUiState(null), {}, {})
    }
}
