package by.ocheretny.brewnote.ui.screens.groupScreen.viewModel

import by.domain.dataSoures.RemoteDataSource
import by.ocheretny.brewnote.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GroupViewModel @Inject constructor(
    private val db: RemoteDataSource,
) : BaseViewModel<GroupViewState, GroupActions>() {

    override fun initViewState(): GroupViewState = GroupViewState()

    fun onButtonClick() =
        safeLaunch {
            db.deleteUserFromGroup("fTy2LLOcSXSWfFAPZ6Ae","5Ecdbry7qcyxE288d3bE")
        }
}
