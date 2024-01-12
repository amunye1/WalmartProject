package com.tc.walmartproject.domain

import com.tc.walmartproject.data.model.CountriesFactItemModel

sealed class NetworkCase{
    class Success(val response: ArrayList<CountriesFactItemModel>): NetworkCase()
    class Error(val errorMessage: String): NetworkCase()
    object Loading: NetworkCase()

}