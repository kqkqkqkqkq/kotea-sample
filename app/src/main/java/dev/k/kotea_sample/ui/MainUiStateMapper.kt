package dev.k.kotea_sample.ui

import dev.k.kotea_sample.presentation.MainState
import ru.tinkoff.kotea.android.ui.ResourcesProvider
import ru.tinkoff.kotea.android.ui.UiStateMapper

internal class MainUiStateMapper : UiStateMapper<MainState, MainUiState> {
    override fun ResourcesProvider.map(state: MainState): MainUiState {
        return MainUiState(
            dataText = state.dataText,
        )
    }
}
