package com.gerard.proyectof.models

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

/*@Composable
fun DemoScreen() {
    val viewModel = viewModel<DataCollectViewModel>()
    when (val state = viewModel.state.collectAsState().value) {
        DemoScreenViewModel.State.Loading -> {
            Text("Loading")
        }
        is DemoScreenViewModel.State.Data -> {
            DemoScreenContent(state.data)
        }
    }
}

class DataCollectViewModel : ViewModel() {
    sealed class State {
        object Loading: State()
        data class Data(val data: String): State()
    }

    private var _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            while (isActive) {
                val data = makeDataLoadCallOnEntry()
                _state.value = State.Data(data)
                // wait one minute and repeat your request
                delay(60 * 1000L)
            }
        }
    }

    suspend fun makeDataLoadCallOnEntry(): String {
        delay(1000)
        return "Hello world"
    }*/