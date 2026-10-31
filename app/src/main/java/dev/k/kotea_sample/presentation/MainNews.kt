package dev.k.kotea_sample.presentation

internal sealed class MainNews {

    class ShowToast(val text: String?): MainNews()
}
