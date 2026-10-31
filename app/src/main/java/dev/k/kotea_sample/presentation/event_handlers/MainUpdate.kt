package dev.k.kotea_sample.presentation.event_handlers

import dev.k.kotea_sample.presentation.MainCommand
import dev.k.kotea_sample.presentation.MainEvent
import dev.k.kotea_sample.presentation.MainEvent.DataLoaded
import dev.k.kotea_sample.presentation.MainNews
import dev.k.kotea_sample.presentation.MainState
import dev.k.kotea_sample.presentation.MainUiEvent.LoadDataButtonClicked
import dev.k.kotea_sample.presentation.MainUiEvent.ThrowErrorButtonClicked
import ru.tinkoff.kotea.core.Next

internal class MainUpdate(
    private val dataLoadedSuccessEventHandler: DataLoadedSuccessEventHandler,
    private val dataLoadedErrorEventHandler: DataLoadedErrorEventHandler,
    private val loadDataButtonClickedUiEventHandler: LoadDataButtonClickedUiEventHandler,
    private val throwErrorButtonClickedUiEventHandler: ThrowErrorButtonClickedUiEventHandler,
) : BaseEventHandler<MainEvent>() {
    override fun update(state: MainState, event: MainEvent): Next<MainState, MainCommand, MainNews> {
        return when (event) {
            is DataLoaded.Success -> dataLoadedSuccessEventHandler.update(state, event)
            is DataLoaded.Error -> dataLoadedErrorEventHandler.update(state, event)
            is LoadDataButtonClicked -> loadDataButtonClickedUiEventHandler.update(state, event)
            is ThrowErrorButtonClicked -> throwErrorButtonClickedUiEventHandler.update(state, event)
        }
    }
}
