package by.ocheretny.brewnote.ui.baseComposables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.ocheretny.brewnote.R
import by.ocheretny.brewnote.theme.White
import by.ocheretny.brewnote.entities.CoffeeUI

@ExperimentalMaterialApi
@Composable
fun CoffeeItem(coffee: CoffeeUI, onClick: (CoffeeUI) -> Unit) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(150.dp)
            .padding(16.dp)
            .clickable {
                coffee.id?.let { onClick(coffee) }
            },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,

        ) {
        Column(modifier = Modifier
            .background(White)
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = coffee.country, fontSize = 16.sp)
            Text(text = coffee.region, fontSize = 16.sp)
            Text(text = coffee.roastDate, fontSize = 16.sp)
            Text(text = coffee.brand, fontSize = 12.sp)
        }
    }
}

@Composable
fun LoadingItem() {
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorItem(errorMessageId: Int = R.string.no_internet_connection) {
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.Center) {
        Text(text = stringResource(id = errorMessageId))
    }
}

@Composable
fun NoItemsItem() {
    Box(modifier = Modifier.fillMaxSize(),
        Alignment.Center) {
        Text(text = stringResource(id = R.string.there_is_nothing_to_show))
    }
}
