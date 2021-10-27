package edu.temple.audiobb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookListAdapter (_context : Context, _booklist : BookList) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {
    private var booklist = _booklist
    var onItemClick: ((Book) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val inflated = inflater.inflate(R.layout.book_list_element, parent, false)
        // Return a new holder instance
        var x = ViewHolder(inflated);
        return x;
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(booklist.get(adapterPosition))
            }
        }
        val titleview = itemView.findViewById<TextView>(R.id.title_list_element);
        val authorview = itemView.findViewById<TextView>(R.id.author_list_element);
        lateinit var title : String;
        lateinit var author : String;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleview.setText(booklist.get(position).t)
        holder.authorview.setText(booklist.get(position).a)
    }

}