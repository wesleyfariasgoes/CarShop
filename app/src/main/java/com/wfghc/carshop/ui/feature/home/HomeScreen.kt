package com.wfghc.carshop.ui.feature.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wfghc.carshop.domain.CarModel
import com.wfghc.carshop.viewmodel.CarViewModel
import com.wfghc.carshop.viewmodel.CategoryViewModel

@Composable
fun MainScreen(onCarClick: (CarModel) -> Unit, categoryViewModel: CategoryViewModel, carViewModel: CarViewModel) {
    val categories by categoryViewModel.categories
    val isLoading by categoryViewModel.isLoading

    val cars by carViewModel.cars
    val isLoadingCars by carViewModel.isLoading


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxSize()
                .background(Color(color = 0xffeffefef))
        ) {
            item {
                HeaderSection(userName = "Wesley Goes", onBellClick = {})
            }

            item {
                SearchSection()
            }

            item {
                if (isLoading) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    CategoryList(categories = categories)
                }
            }

            item {
                Spacer(Modifier.height(height = 16.dp))
                Column(
                    modifier = Modifier
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Popular car", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        Text(text = "View All", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.fillMaxSize())
                    if (isLoadingCars) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    } else {
                        PopularList(cars, onCarClick = onCarClick)
                    }

                }
            }
        }

    }
}

