package com.wfghc.carshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wfghc.carshop.ui.feature.home.MainScreen
import com.wfghc.carshop.ui.theme.CarShopTheme
import com.wfghc.carshop.viewmodel.CarViewModel
import com.wfghc.carshop.viewmodel.CategoryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val categoryViewModel: CategoryViewModel = viewModel()
            val carViewModel: CarViewModel = viewModel()
            MainScreen(onCarClick = {}, categoryViewModel, carViewModel)
        }
    }
}

