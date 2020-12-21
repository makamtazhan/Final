package com.example.afinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_category.view.*

class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_category, container, false)
        val countryCode = arguments?.getString("country_code")!!
        rootView.business.setOnClickListener { nextFragment(countryCode, "business") }
        rootView.entertainment.setOnClickListener { nextFragment(countryCode, "entertainment") }
        rootView.general.setOnClickListener { nextFragment(countryCode, "general") }
        rootView.health.setOnClickListener { nextFragment(countryCode, "health") }
        rootView.science.setOnClickListener { nextFragment(countryCode, "science") }
        rootView.sports.setOnClickListener { nextFragment(countryCode, "sports") }
        rootView.technology.setOnClickListener { nextFragment(countryCode, "technology") }
        return rootView
    }

    private fun nextFragment(country: String, category: String) {
        val bundle = Bundle()
        bundle.putString("country_code", country)
        bundle.putString("category", category)
        val action = CategoryFragmentDirections.actionCategoryToList()
        view?.findNavController()?.navigate(R.id.newsListFragment, bundle)
    }
}