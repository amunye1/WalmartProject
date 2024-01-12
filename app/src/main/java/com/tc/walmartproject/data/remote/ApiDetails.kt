package com.tc.walmartproject.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiDetails {
    const val BASE_URL = "https://gist.githubusercontent.com/peymano-wmt/"

    const val  ENDPOINT = "32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json"

    //builder will have the retrofit.builder object
    //Gsonconvert converts java into java object into json representation
    //base url is just the domain of the site you want to go to
//    val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)      // We tell it the main website address.
        .client(OkHttpClient.Builder().
        addInterceptor(HttpLoggingInterceptor().
        setLevel(HttpLoggingInterceptor.Level.BODY)).build())// We add a logging tool to see what happens during requests.
        //Body represents the loggin level for HttpLoggingInterceptor tool
        //it means that the interceptor will log detailed information about the request and response bodies.
        .addConverterFactory(GsonConverterFactory.create())// Use Gson to convert data between JSON and Java objects.
        .build()
    //take api interfaces as a parameter and it references the class . java
    // We create a 'service' to help us communicate with the website's parts.

    val service = retrofit.create(ApiEndpoint::class.java)
}

