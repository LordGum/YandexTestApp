package com.example.animeapp.data.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class PosterImage (
    @SerializedName("tiny")
    @Expose
    val tiny: String,
    @SerializedName("large")
    @Expose
    val large: String,
    @SerializedName("small")
    @Expose
    val small: String,
    @SerializedName("medium")
    @Expose
    val medium: String,
    @SerializedName("original")
    @Expose
    val original: String
): Serializable