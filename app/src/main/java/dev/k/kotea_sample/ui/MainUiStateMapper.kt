package dev.k.kotea_sample.ui

import androidx.compose.ui.res.stringResource
import dev.k.kotea_sample.R
import dev.k.kotea_sample.presentation.MainState
import dev.k.kotea_sample.ui.state.MainUiState
import ru.tinkoff.kotea.android.ui.ResourcesProvider
import ru.tinkoff.kotea.android.ui.UiStateMapper

internal class MainUiStateMapper : UiStateMapper<MainState, MainUiState> {
    override fun ResourcesProvider.map(state: MainState): MainUiState {
        return when {
            state.isLoading -> MainUiState.Loading
            state.dataText != null -> MainUiState.Content(state.dataText)
            state.error != null -> MainUiState.Error(getString(R.string.main_error_text, state.error.localizedMessage))
            else -> MainUiState.Loading
        }
    }
}
