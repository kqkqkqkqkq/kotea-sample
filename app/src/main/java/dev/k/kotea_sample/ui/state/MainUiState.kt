package dev.k.kotea_sample.ui.state

internal sealed class MainUiState {

    object Loading: MainUiState()

    class Content(val dataText: String): MainUiState()

    class Error(val error: String): MainUiState()
}
