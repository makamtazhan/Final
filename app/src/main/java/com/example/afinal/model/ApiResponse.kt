package com.example.afinal.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("status")
    var status: String,
    @SerializedName("totalResults")
    var totalResults: Int,
    @SerializedName("articles")
    var articles: List<Article>
)