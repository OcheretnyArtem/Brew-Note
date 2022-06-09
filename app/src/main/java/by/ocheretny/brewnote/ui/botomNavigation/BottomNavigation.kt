package by.ocheretny.brewnote.ui.botomNavigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import by.ocheretny.brewnote.ui.screens.NavGraphs
import by.ocheretny.brewnote.ui.screens.appCurrentDestinationAsState
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.utils.startDestination


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun BottomBar(
    navController: NavController,
) {
    val currentDestination =
        navController.appCurrentDestinationAsState().value ?: NavGraphs.root.startDestination

    BottomNavigation {
        BottomBarDestination.values().forEach { destination ->
            BottomNavigationItem(selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigate(direction = destination.direction,
                        navOptionsBuilder = fun NavOptionsBuilder.() {
                            launchSingleTop = true
                        })
                },
                icon = {
                    Icon(destination.icon,
                        contentDescription = stringResource(id = destination.label))
                },
                label = { Text(text = stringResource(id = destination.label)) }
            )
        }
    }
}