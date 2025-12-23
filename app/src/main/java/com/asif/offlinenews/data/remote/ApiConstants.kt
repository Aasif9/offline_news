package com.asif.offlinenews.data.remote

//why we use object and not
object ApiConstants {
    const val BASE_URL = "https://saurav.tech/NewsAPI/"

    //Endpoints
    const val TOP_HEADLINES = "top-headlines/category/{category}/{country}.json"

    const val EVERYTHING = "everything/{source}.json"

    const val SOURCES = "sources.json"
}