package com.example.tema31

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tema31.data.Book
import kotlinx.android.synthetic.main.item_cell.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    private var bookList = emptyList<Book>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cell , parent, false)
        )
    }

    override fun getItemCount(): Int {
        return bookList.size;
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = bookList[position]
        holder.itemView.titleView.text=currentItem.title
        holder.itemView.authorView.text=currentItem.author
        holder.itemView.descriptionView.text=currentItem.description
    }

    fun setData(book: List<Book>)
    {
        this.bookList=book
        notifyDataSetChanged()
    }
}