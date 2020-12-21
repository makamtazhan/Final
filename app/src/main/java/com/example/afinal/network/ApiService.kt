package com.example.afinal.network

import com.example.afinal.model.ApiResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("top-headlines/category/{category}/{country_code}.json")
    fun getNewsList(
        @Path("category") category: String,
        @Path("country_code") country_code: String
    ): Call<ApiResponse>

}