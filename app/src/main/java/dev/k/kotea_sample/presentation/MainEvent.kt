package dev.k.kotea_sample.presentation

internal sealed class MainEvent {

    sealed class DataLoaded: MainEvent() {

        class Success(val dataText: String) : DataLoaded()

        class Error(val throwable: Throwable): DataLoaded()
    }
}
