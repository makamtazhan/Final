package com.example.afinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.afinal.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)
        rootView.back.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailToMain()
            view?.findNavController()?.navigate(action)
        }
        val item = arguments?.getSerializable("item") as Article
        rootView.title.text = item.title
        rootView.author.text = item.author
        Picasso.get().load(item.urlToImage).into(rootView.image)
        rootView.description.text = item.description
        rootView.publishedAt.text = item.publishedAt
        rootView.content.text = item.content
        return rootView
    }

}