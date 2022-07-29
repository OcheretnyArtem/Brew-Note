package by.ocheretny.brewnote.ui.screens.groupScreen.viewModel

import by.data.remote.entities.UserRemote
import by.ocheretny.brewnote.base.viewModel.ViewState

data class GroupViewState(
    val users: List<UserRemote> = emptyList()
) : ViewState