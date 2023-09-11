package com.bxlform.jsonapi_ex.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bxlform.jsonapi_ex.R
import com.bxlform.jsonapi_ex.api.models.Posts

class PostAdapter() : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private  val  listPosts: MutableList<Posts> = mutableListOf()


    class ViewHolder(view : View):RecyclerView.ViewHolder(view) {
        val postIdText : TextView = view.findViewById(R.id.tv_id)
        val userIdText : TextView = view.findViewById(R.id.tv_user_id)
        val titleText : TextView = view.findViewById(R.id.tv_title)
        val bodyText : TextView = view.findViewById(R.id.tv_body)
//        val postIdText : TextView = view.findViewById(R.id.tv_id2)
//        val userIdText : TextView = view.findViewById(R.id.tv_user_id2)
//        val titleText : TextView = view.findViewById(R.id.tv_title2)
//        val bodyText : TextView = view.findViewById(R.id.tv_body2)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item_layout, parent, false)
            //.inflate(R.layout.post_item_layout2, parent, false)

        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //listPosts.get(position).body
        //val post = listPosts[position]
        holder.postIdText.text = listPosts[position].id.toString()
        holder.titleText.text = listPosts[position].title
        holder.bodyText.text = listPosts[position].body
        holder.userIdText.text = listPosts[position].userId.toString()


    }

    override fun getItemCount(): Int {
        return  listPosts.size
    }


    fun updatePosts(posts : MutableList<Posts>){
        listPosts.clear()
        listPosts.addAll(posts)
        notifyDataSetChanged()
    }

}