package by.ocheretny.brewnote.ui.screens.coffeeScreen.viewModel

import by.data.parsres.Mapper
import by.data.remote.TestFireStore
import by.ocheretny.brewnote.base.viewModel.BaseViewModel
import by.ocheretny.brewnote.exceptions.ExceptionParser
import by.domain.entities.Coffee
import by.domain.repositories.DatabaseRepository
import by.ocheretny.brewnote.entities.CoffeeUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class CoffeeViewModel @Inject constructor(
    private val dBRepo: DatabaseRepository,
    private val exceptionParser: ExceptionParser,
    private val coffeeMapper: Mapper<Coffee, CoffeeUI>,
    private val testFireStore: TestFireStore
) : BaseViewModel<CoffeeViewState, CoffeeActions>() {

    override fun initViewState(): CoffeeViewState = CoffeeViewState.Loading

    init {
        safeLaunch {
            dBRepo.getAllCoffee().collect { coffee ->
                if (coffee.isEmpty()) {
                    reduceState {
                        CoffeeViewState.NoItems
                    }
                } else {
                    reduceState {
                        CoffeeViewState.Display(coffee.map {
                            coffeeMapper.map(it)
                        })
                    }
                }
            }
        }
    }

    override fun consumeError(throwable: Throwable?) {
        reduceState {
            CoffeeViewState.Error(exceptionParser.getExceptionNameId(throwable))
        }
    }

    fun onAddButtonClick() {
        safeLaunch {
            testFireStore.test()
//            dBRepo.insert(Coffee(
//                country = "Indonesia",
//                region = "Java",
//                variety = "Tipika",
//                processing = "Washed",
//                brand = "KCR",
//                roastDate = "21.02.22"
//            ))
        }
    }
}
