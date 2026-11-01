package dev.k.kotea_sample.presentation

internal sealed class MainCommand {

    class LoadData(
        val shouldThrowError: Boolean,
        val delay: Long = 0L,
    ) : MainCommand()
}
