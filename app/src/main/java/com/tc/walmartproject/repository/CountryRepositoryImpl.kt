package com.tc.walmartproject.repository

import com.tc.walmartproject.data.ApiEndpoint
import com.tc.walmartproject.ui.countries.data.CountriesFactItemModel
import retrofit2.Response

class CountryRepositoryImpl(private val apiService: ApiEndpoint) : CountryRepository {

    override suspend fun getCountriesFacts(): Response<ArrayList<CountriesFactItemModel>> {
        return apiService.getCountriesFacts()
    }
}
