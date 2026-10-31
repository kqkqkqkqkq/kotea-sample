package dev.k.kotea_sample.presentation.event_handlers

import dev.k.kotea_sample.presentation.MainCommand
import dev.k.kotea_sample.presentation.MainEvent.DataLoaded.Success
import dev.k.kotea_sample.presentation.MainNews
import dev.k.kotea_sample.presentation.MainState
import ru.tinkoff.kotea.core.Next

internal class DataLoadedSuccessEventHandler : BaseEventHandler<Success>() {
    override fun update(state: MainState, event: Success): Next<MainState, MainCommand, MainNews> {
        return Next(
            state = state.copy(
                dataText = event.dataText,
                error = null,
            ),
        )
    }
}
