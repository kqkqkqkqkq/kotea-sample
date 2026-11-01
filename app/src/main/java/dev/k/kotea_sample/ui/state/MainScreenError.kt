package dev.k.kotea_sample.ui.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.k.kotea_sample.R
import dev.k.kotea_sample.core.ui.components.DefaultButton
import dev.k.kotea_sample.ui.state.MainUiState.Error

@Composable
internal fun MainScreenError(
    state: Error,
    onReloadDataClick: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        item {
            Text(
                text = state.error,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.fillMaxWidth(),
            )
        }
        item {
            DefaultButton(text = stringResource(R.string.main_reload_data)) {
                onReloadDataClick()
            }
        }
    }
}
