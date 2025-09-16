package com.wfghc.carshop.ui.feature.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.wfghc.carshop.viewmodel.CategoryViewModel

@Composable
fun MainScreen(categoryViewModel: CategoryViewModel) {
    val categories by categoryViewModel.categories
    val isLoading by categoryViewModel.isLoading

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
        }

    }
}

