package by.ocheretny.brewnote.ui.screens.groupScreen.viewModel

import by.data.remote.User
import by.ocheretny.brewnote.base.viewModel.ViewState

data class GroupViewState(
    val users: List<User> = emptyList()
) : ViewState