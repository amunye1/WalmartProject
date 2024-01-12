package com.tc.walmartproject.ui.countries.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tc.walmartproject.domain.getCountriesFactsUseCase

class CountriesViewModelFactory(private val getCountriesFactsUseCase: getCountriesFactsUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountriesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CountriesViewModel(getCountriesFactsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}