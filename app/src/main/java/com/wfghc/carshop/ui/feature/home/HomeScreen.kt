package com.wfghc.carshop.ui.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun MainScreen() {
    Box(
      modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.fillMaxSize()
            .fillMaxSize()
            .background(Color(color = 0xffeffefef))) {
            item {
                HeaderSection (userName = "Wesley Goes", onBellClick = {})
            }

            item {
                SearchSection()
            }

        }

    }
}