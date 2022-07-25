package by.ocheretny.brewnote.ui.screens.coffeeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import by.ocheretny.brewnote.ui.baseComposables.CoffeeItem
import by.ocheretny.brewnote.ui.baseComposables.ErrorItem
import by.ocheretny.brewnote.ui.baseComposables.LoadingItem
import by.ocheretny.brewnote.ui.baseComposables.NoItemsItem
import by.ocheretny.brewnote.ui.screens.coffeeScreen.viewModel.CoffeeViewModel
import by.ocheretny.brewnote.ui.screens.coffeeScreen.viewModel.CoffeeViewState
import by.ocheretny.brewnote.ui.screens.destinations.SomeScrenDestination
import by.ocheretny.domain.entity.Coffee
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
@Destination
@RootNavGraph(start = true)
fun CoffeeScreen(
    viewModel: CoffeeViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
) {
    val viewState = viewModel.viewState.collectAsState()

    when (viewState.value) {
        is CoffeeViewState.Loading -> {
            LoadingListOfCoffeeState()
        }
        is CoffeeViewState.Display -> {
            val coffeeItems = (viewState.value as CoffeeViewState.Display).listOfCoffee
            DisplayListOfCoffeeState(
                coffeeItems,
                {
                    viewModel.onAddButtonClick()
                },
                {
                    navigator.navigate(SomeScrenDestination(it))
                }
            )
        }
        is CoffeeViewState.Error -> {
            val errorMessageId = (viewState.value as CoffeeViewState.Error).errorMessageId
            ErrorListOfCoffeeState(errorMessageId)
        }
        CoffeeViewState.NoItems -> {
            NoItemsListOfCoffeeState(
                onButtonClick = {
                    viewModel.onAddButtonClick()
                }
            )
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun DisplayListOfCoffeeState(
    list: List<Coffee>,
    onButtonClick: () -> Unit,
    onItemClick: (Coffee) -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp, 16.dp, 16.dp, 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.SpaceEvenly) {
            items(items = list) { coffee ->
                CoffeeItem(coffee) {
                    onItemClick(it)
                }
            }
        }
        FloatingActionButton(
            onClick = onButtonClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .padding(),
        ) {
            Icon(Icons.Default.Add, "")
        }
    }
}

@Composable
fun LoadingListOfCoffeeState() {
    LoadingItem()
}

@Composable
fun ErrorListOfCoffeeState(errorMessageId: Int) {
    ErrorItem(errorMessageId)
}

@Composable
fun NoItemsListOfCoffeeState(onButtonClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        NoItemsItem()
        FloatingActionButton(
            onClick = onButtonClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),

            ) {
            Icon(Icons.Default.Add, "")
        }
    }
}

@Composable
@Destination
fun SomeScren(
    coffee: Coffee,
    navigator: DestinationsNavigator,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TopAppBar(
            modifier = Modifier.align(Alignment.TopCenter),
            navigationIcon = {
                Icon(imageVector = Icons.Default.ArrowBack,
                    "",
                    Modifier
                        .clickable { navigator.popBackStack() }
                        .padding(AppBarDefaults.ContentPadding))
            },
            title = {
                Text(text = coffee.brand)
            }
        )
        Column {
            Text(text = coffee.roastDate)
            Text(text = coffee.id.toString())
            Text(text = coffee.region)
            Text(text = coffee.variety)
            Text(text = coffee.country)
            Text(text = coffee.brand)
        }
    }
}


