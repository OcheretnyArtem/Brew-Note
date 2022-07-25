package by.ocheretny.brewnote.ui.screens.coffeeScreen.viewModel

import by.ocheretny.brewnote.base.viewModel.BaseViewModel
import by.ocheretny.brewnote.exceptions.ExceptionParser
import by.domain.entity.Coffee
import by.domain.repositories.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class CoffeeViewModel @Inject constructor(
    private val DBRepo: DatabaseRepository,
    private val exceptionParser: ExceptionParser,
) : BaseViewModel<CoffeeViewState, CoffeeActionState>() {

    override fun initViewState(): CoffeeViewState = CoffeeViewState.Loading

    init {
        safeLaunch {
            DBRepo.getAllCoffee().collect { coffee ->
                if (coffee.isEmpty()) {
                    reduceState {
                        CoffeeViewState.NoItems
                    }
                } else {
                    reduceState {
                        CoffeeViewState.Display(coffee)
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
            DBRepo.insert(Coffee(
                country = "Indonesia",
                region = "Java",
                variety = "Tipika",
                processing = "Washed",
                brand = "KCR",
                roastDate = "21.02.22"
            ))
        }
    }
}
