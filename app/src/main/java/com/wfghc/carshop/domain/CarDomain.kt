package com.wfghc.carshop.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CarDomain(
    val title: String="",
    val description: String="",
    val totalCapacity: String="",
    val highestSpeed: String="",
    val engineOutput: String="",
    val picUrl: String="",
    val price: Double=0.0,
    val rating: Double=0.0,
): Parcelable
