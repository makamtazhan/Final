package com.example.afinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.model.ApiResponse
import com.example.afinal.model.Article
import com.example.afinal.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsListFragment : Fragment(), Adapter.ItemClickListener {
    lateinit var list: MutableList<Article>
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var viewAdapter: Adapter
    private lateinit var viewManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_news_list, container, false)
        list = ArrayList()

        myRecyclerView = rootView.findViewById(R.id.myRecyclerView)
        viewManager = LinearLayoutManager(context)
        myRecyclerView.layoutManager = viewManager
        val dividerItemDecoration = DividerItemDecoration(
            myRecyclerView.context,
            viewManager.orientation
        )
        myRecyclerView.addItemDecoration(dividerItemDecoration)
        viewAdapter = context?.let { Adapter(list, it, this) }!!
        myRecyclerView.adapter = viewAdapter
        viewAdapter.notifyDataSetChanged()
        val country = arguments?.getString("country_code")!!
        val category = arguments?.getString("category")!!
        getList(country, category)
        return rootView
    }

    private fun getList(country: String, category: String) {
        val list = ArrayList<Article>()
        ApiClient.getApiService().getNewsList(category, country).enqueue(object :
            Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                list.addAll(response.body()?.articles!!)
                viewAdapter.list = list
                viewAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(context, "error", Toast.LENGTH_LONG).show()
            }

        })

    }

    override fun itemClick(position: Int, item: Article?) {
        val bundle = Bundle()
        bundle.putSerializable("item", item)
        findNavController().navigate(R.id.detailFragment, bundle)
    }

}