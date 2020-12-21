package com.example.afinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_country.view.*

class CountryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_country, container, false)
        rootView.india.setOnClickListener { nextFragment("in") }
        rootView.us.setOnClickListener { nextFragment("us") }
        rootView.au.setOnClickListener { nextFragment("au") }
        rootView.ru.setOnClickListener { nextFragment("ru") }
        rootView.fr.setOnClickListener { nextFragment("fr") }
        rootView.gb.setOnClickListener { nextFragment("gb") }
        return rootView
    }

    private fun nextFragment(country: String) {
        val bundle = Bundle()
        bundle.putString("country_code", country)
        val action = CountryFragmentDirections.actionCountryToCategory()
        view?.findNavController()?.navigate(R.id.categoryFragment, bundle)
    }
}