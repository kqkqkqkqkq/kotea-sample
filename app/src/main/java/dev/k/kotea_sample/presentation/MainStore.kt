package dev.k.kotea_sample.presentation

import dev.k.kotea_sample.presentation.command_handlers.BaseCommandHandler
import dev.k.kotea_sample.presentation.event_handlers.MainUpdate
import ru.tinkoff.kotea.core.KoteaStore
import ru.tinkoff.kotea.core.Store

internal class MainStore(
    private val initialCommands: List<MainCommand>,
    private val commandsFlowHandlers: List<BaseCommandHandler>,
    private val update: MainUpdate,
) : Store<MainState, MainUiEvent, MainNews> by KoteaStore(
    initialState = MainState.INITIAL,
    initialCommands = initialCommands,
    commandsFlowHandlers = commandsFlowHandlers,
    update = update,
)
