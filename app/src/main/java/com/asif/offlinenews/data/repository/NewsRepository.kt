package com.asif.offlinenews.data.repository

import com.asif.offlinenews.data.model.NewsResponse
import com.asif.offlinenews.data.model.Source
import com.asif.offlinenews.data.remote.RetrofitClient
import com.asif.offlinenews.utils.Resource

class NewsRepository {
    suspend fun getTopHeadlines(
          category: String,
          country:String
    ): Resource<NewsResponse>{
        return try {
            val response = RetrofitClient.api.getTopHeadlines(category,country)
            Resource.Success(response)
        } catch (e:Exception){
            Resource.Error(e.message ?: "Unknown Error")
        }
    }
    suspend fun getEverything(
       source: String
    ): Resource<NewsResponse>{
        return try {
            val response = RetrofitClient.api.getEverything(source)
            Resource.Success(response)
        } catch (e:Exception){
            Resource.Error(e.message ?: "Unknown Error")
        }
    }





}

//No Loading / Error handling yet ❌
//
//Right now:
//
//Network fails → app crashes
//
//No loading state
//
//No error state
//
//So we fix this with a Resource wrapper

//class NewsRepository {
//
//    suspend fun getTopHeadlines(
//        category: String,
//        country:String
//    )= RetrofitClient.api.getTopHeadlines(category,country)
//
//    suspend fun getEveything(
//        source: String
//    )= RetrofitClient.api.getEverything(source)
//
//}