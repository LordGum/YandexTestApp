package com.example.animeapp.data.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CoverImage (
    @SerializedName("tiny")
    @Expose
    val tiny: String,
    @SerializedName("large")
    @Expose
    val large: String,
    @SerializedName("small")
    @Expose
    val small: String,
    @SerializedName("original")
    @Expose
    val original: String,
): Serializable