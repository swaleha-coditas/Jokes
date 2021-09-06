package com.example.jokes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val context : Context, private var jokeList : ArrayList<Jokes>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var tvJoke : TextView = itemView.findViewById(R.id.tvJoke)
        var tvPunchline : TextView = itemView.findViewById(R.id.tvPunchline)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.tvJoke.text = jokeList[position].toString()
        holder.tvPunchline.text = jokeList[position].toString()
    }

    override fun getItemCount(): Int {
        return jokeList.size
    }

}

