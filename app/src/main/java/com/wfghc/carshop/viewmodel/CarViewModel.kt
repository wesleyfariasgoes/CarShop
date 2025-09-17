package com.wfghc.carshop.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wfghc.carshop.domain.CarModel
import androidx.compose.runtime.State
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class CarViewModel : ViewModel() {
    private val _cars = mutableStateOf<List<CarModel>>(emptyList())
    val cars: State<List<CarModel>> = _cars

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    init {
        fetchCars()
    }

    private fun fetchCars() {
        val ref = FirebaseDatabase.getInstance().getReference("Cars")

        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val carsList = mutableListOf<CarModel>()
                for (carSnapshot in snapshot.children) {
                    carSnapshot.getValue(CarModel::class.java)?.let {
                        carsList.add(it)
                    }
                }
                _cars.value = carsList
                _isLoading.value = false
            }

            override fun onCancelled(error: DatabaseError) {
                _isLoading.value = false
            }

        })
    }
}