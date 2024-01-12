package com.tc.walmartproject.domain

import com.tc.walmartproject.data.repository.CountryRepository
import kotlinx.coroutines.flow.Flow

class getCountriesFactsUseCase(private val repository: CountryRepository) {

    suspend fun getCountriesFacts(): Flow<NetworkCase> {
        return repository.getCountriesFacts()

    }
}