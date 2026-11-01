package dev.k.kotea_sample.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.k.kotea_sample.R
import dev.k.kotea_sample.core.ui.theme.KoteasampleTheme
import dev.k.kotea_sample.ui.state.MainScreenContent
import dev.k.kotea_sample.ui.state.MainScreenError
import dev.k.kotea_sample.ui.state.MainScreenLoading
import dev.k.kotea_sample.ui.state.MainUiState
import dev.k.kotea_sample.ui.state.MainUiState.Content
import dev.k.kotea_sample.ui.state.MainUiState.Error
import dev.k.kotea_sample.ui.state.MainUiState.Loading

@Composable
internal fun MainScreen(
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
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            when (state) {
                is Loading -> MainScreenLoading(state)
                is Content -> MainScreenContent(state, onThrowErrorClick, onLoadDataClick)
                is Error -> MainScreenError(state, onLoadDataClick)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    KoteasampleTheme {
        MainScreen(Content("123"), {}, {})
    }
}
