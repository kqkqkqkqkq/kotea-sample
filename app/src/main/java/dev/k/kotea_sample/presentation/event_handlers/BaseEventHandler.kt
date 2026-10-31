package dev.k.kotea_sample.presentation.event_handlers

import dev.k.kotea_sample.presentation.MainCommand
import dev.k.kotea_sample.presentation.MainEvent
import dev.k.kotea_sample.presentation.MainNews
import dev.k.kotea_sample.presentation.MainState
import ru.tinkoff.kotea.core.Update

internal abstract class BaseEventHandler<E: MainEvent> : Update<MainState, E, MainCommand, MainNews>
