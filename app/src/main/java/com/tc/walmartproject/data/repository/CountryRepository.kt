package com.tc.walmartproject.data.repository

import com.tc.walmartproject.data.model.CountriesFactItemModel
import com.tc.walmartproject.domain.NetworkCase
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface CountryRepository {
    suspend fun getCountriesFacts(): Flow<NetworkCase>
}
