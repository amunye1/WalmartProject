package com.tc.walmartproject.data

import com.tc.walmartproject.ui.countries.data.CountriesFactItemModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndpoint {
    @GET(ApiDetails.ENDPOINT)
    suspend fun getCountriesFacts(): Response<ArrayList<CountriesFactItemModel>>
}