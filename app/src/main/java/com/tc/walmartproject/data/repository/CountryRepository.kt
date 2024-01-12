package com.tc.walmartproject.data.repository

import com.tc.walmartproject.domain.NetworkCase
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    suspend fun getCountriesFacts(): Flow<NetworkCase>
}
