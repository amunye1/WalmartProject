package com.tc.walmartproject.domain

import com.tc.walmartproject.data.repository.CountryRepository
import com.tc.walmartproject.data.model.CountriesFactItemModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class getCountriesFactsUseCase(private val repository: CountryRepository){

    suspend fun getCountriesFacts(): Flow<NetworkCase> {
            return repository.getCountriesFacts()

    }
}