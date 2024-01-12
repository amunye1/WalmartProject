package com.tc.walmartproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tc.walmartproject.ui.countries.view.CountryFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if savedInstanceState is null to avoid fragment overlapping
        if (savedInstanceState == null) {
            // Initialize the fragment
            val countryFragment = CountryFragment()

            // Use supportFragmentManager to begin a transaction,
            // then replace the fragment container with your CountryFragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, countryFragment).commit()
        }
    }
}
