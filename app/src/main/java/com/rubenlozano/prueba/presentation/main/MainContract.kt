package com.rubenlozano.prueba.presentation.mainimport com.rubenlozano.prueba.data.model.Userimport kotlinx.coroutines.flow.StateFlowinterface MainContract {    interface ViewModel {        val uiState: StateFlow<UIState>        fun onEventDispatcher(intent: Intent)    }    data class UIState(        val userList: List<User> = emptyList(),    )    interface Intent {        data class MoveToDetail(val user: User) : Intent    }}