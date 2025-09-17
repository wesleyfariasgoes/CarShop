package com.wfghc.carshop.ui.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.wfghc.carshop.R
import com.wfghc.carshop.domain.CarModel

@Composable
fun PopularList(
    cars: List<CarModel>,
    onCarClick: (CarModel) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, bottom = 130.dp)
            .fillMaxSize()
            .height(600.dp)
    ) {
        items(cars) { car ->
            Card(
                modifier = Modifier.padding(8.dp)
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.gray))
                    .clickable { onCarClick(car) },
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Image(painter = rememberAsyncImagePainter(car.picUrl),
                        contentDescription = null,
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop)

                    Text(text = car.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 8.dp))

                    Text(text = "$${car.price}",
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 4.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PopularListPreview() {
    PopularList(
        cars = listOf(
            CarModel(
                title = "Toyota Camary",
                description = "A reliable and confortable sedan",
                totalCapacity = "5 seats",
                highestSpeed = "200 km/h",
                engineOutput = "203 hp",
                picUrl = "https://example.com/camary.jpg",
                price = 25000.0,
                rating = 4.5
            ),
            CarModel( title = "Honda Civic",
                description = "A reliable and confortable sedan",
                totalCapacity = "5 seats",
                highestSpeed = "200 km/h",
                engineOutput = "203 hp",
                picUrl = "https://example.com/camary.jpg",
                price = 35000.0,
                rating = 4.5)

        ),
        onCarClick = {}
    )
}