package com.example.animeapp.data.network.pojo

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

data class Datum(
    @SerializedName("id")
    @Expose
    val id: String,
    @SerializedName("attributes")
    @Expose
    val attributes: Attributes,
    val isWatched: Boolean,
    val isFavorite: Boolean
) : Serializable