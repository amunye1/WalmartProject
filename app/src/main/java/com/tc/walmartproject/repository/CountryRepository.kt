package com.tc.walmartproject.repository

import com.tc.walmartproject.ui.countries.data.CountriesFactItemModel
import retrofit2.Response

interface CountryRepository {
    suspend fun getCountriesFacts(): Response<ArrayList<CountriesFactItemModel>>
}
