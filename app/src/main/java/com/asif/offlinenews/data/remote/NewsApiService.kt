package com.asif.offlinenews.data.remote
import com.asif.offlinenews.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Path

//why interface and not normal class for implementing retrofit
//when adding retrofit2 why we need these 3 dependencies
//implementation(libs.retrofit)
//implementation(libs.retrofit.converter.gson)
//implementation(libs.okhttp.logging.interceptor)

interface NewsApiService {

    @GET(ApiConstants.TOP_HEADLINES)
    suspend fun getTopHeadlines(
        @Path("category") category: String,
        @Path("country") country: String
    ):NewsResponse

    suspend fun getEverything(
        @Path("source") source:String
    ):NewsResponse

}