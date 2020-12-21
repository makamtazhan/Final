package com.example.afinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.model.Article
import com.squareup.picasso.Picasso

class Adapter(
    var list: MutableList<Article>,
    private val context: Context,
    private val listener: ItemClickListener
) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var author: TextView = view.findViewById(R.id.author)
        var image: ImageView = view.findViewById(R.id.image)

    }

    interface ItemClickListener {
        fun itemClick(position: Int, item: Article?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.title.text = item.title
        holder.author.text = item.author
        Picasso.get().load(item.urlToImage).into(holder.image)
        holder.itemView.setOnClickListener {
            listener.itemClick(position, item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}