package dev.k.kotea_sample

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.k.kotea_sample.core.ui.theme.KoteasampleTheme
import dev.k.kotea_sample.presentation.MainCommand.LoadData
import dev.k.kotea_sample.presentation.MainNews
import dev.k.kotea_sample.presentation.MainNews.ShowToast
import dev.k.kotea_sample.presentation.MainStore
import dev.k.kotea_sample.presentation.MainUiEvent.LoadDataButtonClicked
import dev.k.kotea_sample.presentation.MainUiEvent.ThrowErrorButtonClicked
import dev.k.kotea_sample.presentation.command_handlers.LoadDataCommandHandler
import dev.k.kotea_sample.presentation.event_handlers.DataLoadedErrorEventHandler
import dev.k.kotea_sample.presentation.event_handlers.DataLoadedSuccessEventHandler
import dev.k.kotea_sample.presentation.event_handlers.LoadDataButtonClickedUiEventHandler
import dev.k.kotea_sample.presentation.event_handlers.MainUpdate
import dev.k.kotea_sample.presentation.event_handlers.ThrowErrorButtonClickedUiEventHandler
import dev.k.kotea_sample.ui.MainScreen
import dev.k.kotea_sample.ui.MainUiStateMapper
import dev.k.kotea_sample.ui.state.MainUiState
import ru.tinkoff.kotea.android.lifecycle.collectOnCreate
import ru.tinkoff.kotea.android.storeViaViewModel

class MainActivity : ComponentActivity() {

    private val mainUiStateMapper = MainUiStateMapper()

    private val store by storeViaViewModel {
        MainStore(
            initialCommands = listOf(
                LoadData(false, 1000L),
            ),
            commandsFlowHandlers = listOf(
                LoadDataCommandHandler(),
            ),
            update = MainUpdate(
                dataLoadedSuccessEventHandler = DataLoadedSuccessEventHandler(),
                dataLoadedErrorEventHandler = DataLoadedErrorEventHandler(),
                loadDataButtonClickedUiEventHandler = LoadDataButtonClickedUiEventHandler(),
                throwErrorButtonClickedUiEventHandler = ThrowErrorButtonClickedUiEventHandler(),
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        store.collectOnCreate(
            activity = this,
            uiStateMapper = mainUiStateMapper,
            stateCollector = ::collectState,
            newsCollector = ::handleNews,
        )
    }

    private fun collectState(state: MainUiState) {
        setContent {
            KoteasampleTheme {
                MainScreen(
                    state = state,
                    onLoadDataClick = { store.dispatch(LoadDataButtonClicked) },
                    onThrowErrorClick = { store.dispatch(ThrowErrorButtonClicked) },
                )
            }
        }
    }

    private fun handleNews(news: MainNews) {
        when (news) {
            is ShowToast -> Toast.makeText(this, news.text, LENGTH_SHORT).show()
        }
    }
}
