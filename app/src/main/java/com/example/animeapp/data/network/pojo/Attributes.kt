package com.example.animeapp.data.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Attributes (
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("canonicalTitle")
    @Expose
    val canonicalTitle: String,
    @SerializedName("averageRating")
    @Expose
    val averageRating: String,
    @SerializedName("posterImage")
    @Expose
    val posterImage: PosterImage,
    @SerializedName("coverImage")
    @Expose
    val coverImage: CoverImage,
    @SerializedName("episodeCount")
    @Expose
    val episodeCount: Int,
    @SerializedName("episodeLength")
    @Expose
    val episodeLength: Int,
    @SerializedName("youtubeVideoId")
    @Expose
    val youtubeVideoId: String
): Serializable