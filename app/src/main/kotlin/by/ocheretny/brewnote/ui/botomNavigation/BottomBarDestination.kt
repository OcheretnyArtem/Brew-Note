package by.ocheretny.brewnote.ui.botomNavigation

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector
import by.ocheretny.brewnote.R
import by.ocheretny.brewnote.ui.screens.destinations.CoffeeScreenDestination
import by.ocheretny.brewnote.ui.screens.destinations.GroupScreenDestination
import by.ocheretny.brewnote.ui.screens.destinations.ProfileScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

@ExperimentalMaterialApi
@ExperimentalFoundationApi
enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    @StringRes val label: Int,
) {

    Coffee(CoffeeScreenDestination, Icons.Default.Home, R.string.coffee),
    Profile(ProfileScreenDestination, Icons.Default.Info, R.string.profile),
    Groups(GroupScreenDestination, Icons.Default.Place, R.string.groups)
}
