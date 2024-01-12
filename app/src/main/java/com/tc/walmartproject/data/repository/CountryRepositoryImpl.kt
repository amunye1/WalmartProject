package com.tc.walmartproject.data.repository

import com.tc.walmartproject.data.remote.ApiEndpoint
import com.tc.walmartproject.domain.NetworkCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CountryRepositoryImpl(private val apiService: ApiEndpoint) : CountryRepository {

    override suspend fun getCountriesFacts(): Flow<NetworkCase> {
        return flow {
            try {
                val response = apiService.getCountriesFacts()
                emit(NetworkCase.Loading)
                if (response.isSuccessful && response.body() != null) {
                    emit(NetworkCase.Success(response.body()!!))
                } else {
                    emit(NetworkCase.Error(response.message()))
                }
            } catch (error: Exception) {
                emit(NetworkCase.Error(error.message ?: "Unknown error occurred"))
            }
        }
    }
}
