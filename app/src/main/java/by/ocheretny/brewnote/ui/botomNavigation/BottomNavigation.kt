package by.ocheretny.brewnote.ui.botomNavigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import by.ocheretny.brewnote.ui.NavGraphs
import by.ocheretny.brewnote.ui.appCurrentDestinationAsState
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.navigateTo
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
                    navController.navigate(direction = destination.direction) {
                        launchSingleTop = true
                    }
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