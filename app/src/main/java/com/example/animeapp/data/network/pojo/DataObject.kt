package com.example.animeapp.data.network.pojo

import androidx.lifecycle.LiveData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class DataObject(
    @SerializedName("data")
    @Expose
    val listOfData: List<Datum>
)