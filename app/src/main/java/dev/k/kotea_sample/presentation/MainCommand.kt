package dev.k.kotea_sample.presentation

internal sealed class MainCommand {

    class LoadData(val shouldThrowError: Boolean) : MainCommand()
}
