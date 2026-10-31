package dev.k.kotea_sample.presentation

internal sealed class MainUiEvent : MainEvent() {

    object LoadDataButtonClicked : MainUiEvent()

    object ThrowErrorButtonClicked : MainUiEvent()
}
