package dev.k.kotea_sample.presentation.command_handlers

import dev.k.kotea_sample.presentation.MainCommand
import dev.k.kotea_sample.presentation.MainCommand.LoadData
import dev.k.kotea_sample.presentation.MainEvent
import dev.k.kotea_sample.presentation.MainEvent.DataLoaded.Error
import dev.k.kotea_sample.presentation.MainEvent.DataLoaded.Success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map

internal class LoadDataCommandHandler: BaseCommandHandler() {
    override fun handle(commands: Flow<MainCommand>): Flow<MainEvent> {
        return commands.filterIsInstance<LoadData>()
            .map { command ->
                Success("Success")
                    .takeIf { !command.shouldThrowError }
                    ?: Error(Throwable("Error"))
            }
    }
}
