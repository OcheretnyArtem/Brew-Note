package by.ocheretny.brewnote.ui.screens.coffeeScreen.viewModel

import by.ocheretny.brewnote.base.viewModel.ViewState
import by.domain.entity.Coffee

sealed class CoffeeViewState : ViewState {

    object Loading : CoffeeViewState()

    data class Display(val listOfCoffee: List<Coffee>) : CoffeeViewState()

    data class Error(val errorMessageId: Int) : CoffeeViewState()

    object NoItems : CoffeeViewState()

}
