package by.ocheretny.brewnote.ui.screens.profileDitalesScreen.viewModel

import by.ocheretny.brewnote.base.viewModel.BaseViewModel

class ProfileDetailsViewModel :
    BaseViewModel<ProfileDetailsViewState, ProfileDetailsActionState>() {

    override fun initViewState(): ProfileDetailsViewState = ProfileDetailsViewState()
}