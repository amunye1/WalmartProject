package com.tc.walmartproject.data.remote

import com.tc.walmartproject.data.model.CountriesFactItemModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndpoint {
    @GET(ApiDetails.ENDPOINT)
    suspend fun getCountriesFacts(): Response<ArrayList<CountriesFactItemModel>>
}