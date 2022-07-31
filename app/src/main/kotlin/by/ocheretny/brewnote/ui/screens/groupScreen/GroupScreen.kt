package by.ocheretny.brewnote.ui.screens.groupScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import by.domain.entities.User
import by.ocheretny.brewnote.ui.screens.groupScreen.viewModel.GroupViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun GroupScreen(
    viewModel: GroupViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
) {
    Box {
        val viewState by viewModel.viewState.collectAsState()
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Users(viewState.users)
        }
    }
}

@Composable
fun Users(users: List<User>) {
    LazyColumn(content = {
        items(users){ user ->
            UserItem(user = user)
        }
    })
}
@Composable
fun UserItem(user: User) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(150.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,

        ){
        Column {
            Text(text = user.name)
            Text(text = user.photoURL)
        }
    }

}