package by.ocheretny.brewnote.ui.screens.groupScreen.viewModel

import by.domain.dataSoures.RemoteDataSource
import by.ocheretny.brewnote.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GroupViewModel @Inject constructor(
    private val db : RemoteDataSource
) : BaseViewModel<GroupViewState, GroupActions>() {

    override fun initViewState(): GroupViewState = GroupViewState()

    init {
        safeLaunch {
            db.getUsersByName("artsiom").collect{ list ->
                reduceState {
                    it.copy(users = list)
                }
            }
        }
    }

}
