package dev.k.kotea_sample.presentation.command_handlers

import dev.k.kotea_sample.presentation.MainCommand
import dev.k.kotea_sample.presentation.MainEvent
import ru.tinkoff.kotea.core.CommandsFlowHandler

internal abstract class BaseCommandHandler : CommandsFlowHandler<MainCommand, MainEvent>
