package dev.k.kotea_sample.presentation.event_handlers

import dev.k.kotea_sample.presentation.MainCommand
import dev.k.kotea_sample.presentation.MainEvent.DataLoaded.Error
import dev.k.kotea_sample.presentation.MainNews
import dev.k.kotea_sample.presentation.MainNews.ShowToast
import dev.k.kotea_sample.presentation.MainState
import ru.tinkoff.kotea.core.Next

internal class DataLoadedErrorEventHandler : BaseEventHandler<Error>() {
    override fun update(state: MainState, event: Error): Next<MainState, MainCommand, MainNews> {
        return Next(
            state = state.copy(
                dataText = event.throwable.localizedMessage,
                error = event.throwable,
            ),
            news = listOf(ShowToast(event.throwable.localizedMessage)),
        )
    }
}
