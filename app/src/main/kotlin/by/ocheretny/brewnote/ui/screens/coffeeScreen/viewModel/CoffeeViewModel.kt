package by.ocheretny.brewnote.ui.screens.coffeeScreen.viewModel

import by.data.parsres.Mapper
import by.ocheretny.brewnote.base.viewModel.BaseViewModel
import by.ocheretny.brewnote.exceptions.ExceptionParser
import by.domain.entities.Coffee
import by.domain.dataSoures.LocalDataSource
import by.domain.dataSoures.RemoteDataSource
import by.domain.entities.Infusion
import by.domain.entities.Profile
import by.ocheretny.brewnote.entities.CoffeeUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class CoffeeViewModel @Inject constructor(
    private val dBRepo: LocalDataSource,
    private val db: RemoteDataSource,
    private val exceptionParser: ExceptionParser,
    private val coffeeMapper: Mapper<Coffee, CoffeeUI>,
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
//            db.pushProfileInGroup("O6ltPp0Ml1eWY9cHfoH0", Profile(
//                id = 1,
//                coffee = Coffee(
//                    id = 1,
//                    country = "Keniya",
//                    region = "Central",
//                    variety = "SL28",
//                    processing = "Washed",
//                    photo = "Some Photo",
//                    brand = "KCR",
//                    description = "Cool",
//                    roastDate = "25.08.2019"
//                ),
//                infusions = listOf(
//                    Infusion(id = 1,
//                        profileId = 1,
//                        startSecond = 1,
//                        endSecond = 5,
//                        waitingTime = 10,
//                        countOfWater = 50,
//                        isMixed = false),
//                    Infusion(id = 2,
//                        profileId = 1,
//                        startSecond = 16,
//                        endSecond = 26,
//                        waitingTime = 30,
//                        countOfWater = 50,
//                        isMixed = false)
//                ),
//                device = "V60",
//                totalTime = 60.0,
//                totalWaterWeight = 100.0,
//                waterTemperature = 95.2,
//                dryCoffeeWeight = 15.5,
//                grinderSetting = 7.3,
//                grinderName = "EK47",
//                description = "SOOO COOL",
//                brewedCoffeeWeight = 90.0,
//                tds = 15.3,
//                extraction = 21.0
//            ))
        }
    }
}
