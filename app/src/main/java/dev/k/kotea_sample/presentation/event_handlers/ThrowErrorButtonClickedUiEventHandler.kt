package dev.k.kotea_sample.presentation.event_handlers

import dev.k.kotea_sample.presentation.MainCommand
import dev.k.kotea_sample.presentation.MainCommand.LoadData
import dev.k.kotea_sample.presentation.MainNews
import dev.k.kotea_sample.presentation.MainState
import dev.k.kotea_sample.presentation.MainUiEvent.ThrowErrorButtonClicked
import ru.tinkoff.kotea.core.Next

internal class ThrowErrorButtonClickedUiEventHandler : BaseEventHandler<ThrowErrorButtonClicked>() {
    override fun update(state: MainState, event: ThrowErrorButtonClicked): Next<MainState, MainCommand, MainNews> {
        return Next(
            state = state.copy(
                dataText = null,
                isLoading = true,
            ),
            commands = listOf(LoadData(true, 500L)),
        )
    }
}
