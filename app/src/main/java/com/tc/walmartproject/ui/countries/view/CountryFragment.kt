package com.tc.walmartproject.ui.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tc.walmartproject.R
import com.tc.walmartproject.data.remote.ApiDetails
import com.tc.walmartproject.data.repository.CountryRepositoryImpl
import com.tc.walmartproject.domain.NetworkCase
import com.tc.walmartproject.domain.getCountriesFactsUseCase
import com.tc.walmartproject.ui.countries.viewmodel.CountriesViewModel
import com.tc.walmartproject.ui.countries.viewmodel.CountriesViewModelFactory

class CountryFragment : Fragment() {

    private lateinit var viewModel: CountriesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CountryAdapter
    private lateinit var progressBar: ProgressBar
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val repository = CountryRepositoryImpl(ApiDetails.service)// Initialize your repository here
        val getCountriesFactsUseCase = getCountriesFactsUseCase(repository)
        val viewModelFactory = CountriesViewModelFactory(getCountriesFactsUseCase)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CountriesViewModel::class.java)
        progressBar = view.findViewById(R.id.progressBar)
        recyclerView =
            view.findViewById(R.id.countryRecyclerView) // Replace with your RecyclerView ID
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = CountryAdapter(arrayListOf())
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(CountriesViewModel::class.java)
        viewModel.countriesFact.observe(viewLifecycleOwner, Observer { networkcase ->
            when (networkcase) {
                is NetworkCase.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }

                is NetworkCase.Error -> {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(
                        context,
                        "Error fetching data: ${networkcase.errorMessage}",
                        Toast.LENGTH_LONG
                    ).show()


                }


                is NetworkCase.Success -> {
                    progressBar.visibility = View.INVISIBLE
                    adapter.updateCountries(networkcase.response)
                }



            }

        })

        viewModel.getCountriesFact()
    }
}
