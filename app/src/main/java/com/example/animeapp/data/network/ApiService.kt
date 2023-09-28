package com.example.animeapp.data.network

import com.example.animeapp.data.network.pojo.DataObject
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("anime")
    fun loadList(
        @Query(QUERY_PARAM_CATEGORY) category: String = "",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 20
    ): Single<DataObject>

    companion object{
        private const val QUERY_PARAM_CATEGORY = "filter[categories]"
        private const val QUERY_PARAM_LIMIT = "page[limit]"

        const val TYPE_ADVENTURE = "adventure"
        const val TYPE_FANTASY = "fantasy"
        const val TYPE_COMEDY = "comedy"
    }
}