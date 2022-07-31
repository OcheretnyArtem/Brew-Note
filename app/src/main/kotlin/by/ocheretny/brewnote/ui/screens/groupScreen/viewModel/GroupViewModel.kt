package by.ocheretny.brewnote.ui.screens.groupScreen.viewModel

import by.domain.dataSoures.RemoteDataSource
import by.ocheretny.brewnote.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
val iDs = arrayListOf(
    "nMea7ZaK1iazml6vTznr",
    "pW9eY6p5QrPE8p5tGrdZ"
)

@HiltViewModel
class GroupViewModel @Inject constructor(
    private val db: RemoteDataSource,
) : BaseViewModel<GroupViewState, GroupActions>() {

    override fun initViewState(): GroupViewState = GroupViewState()

    init {
        safeLaunch {
            db.getUsersByIDs(iDs).collect { list ->
                reduceState {
                    it.copy(users = list)
                }
            }
        }
    }

    fun onButtonClick(){
        iDs.add("5Ecdbry7qcyxE288d3bE")
    }
}
