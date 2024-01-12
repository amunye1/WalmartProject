package com.tc.walmartproject.ui.countries.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.walmartproject.data.ApiDetails
import com.tc.walmartproject.repository.CountryRepository
import com.tc.walmartproject.ui.countries.data.CountriesFact
import com.tc.walmartproject.ui.countries.data.CountriesFactItemModel
import kotlinx.coroutines.launch

class CountriesViewModel(private val repository: CountryRepository) : ViewModel() {

    private val _countriesFact = MutableLiveData<ArrayList<CountriesFactItemModel>>()
    val countriesFact: LiveData<ArrayList<CountriesFactItemModel>> = _countriesFact

    fun getCountriesFact(){
        viewModelScope.launch {
            val result = repository.getCountriesFacts()

            if(result.isSuccessful){
                _countriesFact.postValue(result.body())
            }else{
                _countriesFact.postValue(ArrayList())
            }
        }
    }
}
