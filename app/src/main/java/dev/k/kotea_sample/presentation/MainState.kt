package dev.k.kotea_sample.presentation

internal data class MainState (
    val dataText: String?,
    val error: Throwable?,
    val isLoading: Boolean,
) {
    companion object {
        val INITIAL = MainState(
            dataText = null,
            error = null,
            isLoading = true,
        )
    }
}
