package com.tc.walmartproject.ui.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tc.walmartproject.R
import com.tc.walmartproject.data.ApiDetails
import com.tc.walmartproject.repository.CountryRepository
import com.tc.walmartproject.repository.CountryRepositoryImpl
import com.tc.walmartproject.ui.countries.viewmodel.CountriesViewModel
import com.tc.walmartproject.ui.countries.viewmodel.CountriesViewModelFactory

class CountryFragment : Fragment() {

    private lateinit var viewModel: CountriesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CountryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = CountryRepositoryImpl(ApiDetails.service)// Initialize your repository here
        val viewModelFactory = CountriesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CountriesViewModel::class.java)

        recyclerView = view.findViewById(R.id.countryrecyclerview) // Replace with your RecyclerView ID
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = CountryAdapter(arrayListOf())
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(CountriesViewModel::class.java)
        viewModel.countriesFact.observe(viewLifecycleOwner, Observer {
            adapter.updateCountries(it)
        })

        viewModel.getCountriesFact()
    }
}
