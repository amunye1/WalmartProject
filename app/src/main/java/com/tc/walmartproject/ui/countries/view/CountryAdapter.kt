package com.tc.walmartproject.ui.countries.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tc.walmartproject.R
import com.tc.walmartproject.data.model.CountriesFactItemModel

class CountryAdapter(private var countries: ArrayList<CountriesFactItemModel>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_countries_user, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int = countries.size

    fun updateCountries(newCountries: ArrayList<CountriesFactItemModel>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.tvName)
        private val region: TextView = itemView.findViewById(R.id.tvRegion)
        private val code: TextView = itemView.findViewById(R.id.tvCode)
        private val capital: TextView = itemView.findViewById(R.id.tvCapital)

        fun bind(country: CountriesFactItemModel) {
            name.text = country.name
            region.text = country.region
            code.text = country.code
            capital.text = country.capital
        }
    }
}
