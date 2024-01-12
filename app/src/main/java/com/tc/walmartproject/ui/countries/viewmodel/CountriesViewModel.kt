package com.tc.walmartproject.ui.countries.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.walmartproject.domain.getCountriesFactsUseCase
import com.tc.walmartproject.data.model.CountriesFactItemModel
import com.tc.walmartproject.domain.NetworkCase
import kotlinx.coroutines.launch

class CountriesViewModel(private val getCountriesFactsUseCase: getCountriesFactsUseCase) : ViewModel() {

    private val _countriesFact = MutableLiveData<NetworkCase>()
    val countriesFact: LiveData<NetworkCase> = _countriesFact

    fun getCountriesFact(){
        viewModelScope.launch {
            getCountriesFactsUseCase.getCountriesFacts().collect{
                _countriesFact.postValue(it)
            }

//            if(result.isSuccessful){
//                _countriesFact.postValue(result.body())
//            }else{
//                _countriesFact.postValue(ArrayList())
//            }
        }
    }
}
