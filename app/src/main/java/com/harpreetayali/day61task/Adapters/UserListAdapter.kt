package com.harpreetayali.day61task.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.harpreetayali.day61task.Models.Data
import com.harpreetayali.day61task.R

class UserListAdapter(list:ArrayList<Data>, mCtx:Context): RecyclerView.Adapter<UserListAdapter.MyViewHolder>()
{

    private val userList = list
    private val mCtx = mCtx

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserListAdapter.MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserListAdapter.MyViewHolder, position: Int)
    {
        holder.user_name.text = "${userList[position].first_name} : ${userList[position].last_name}"
        holder.user_email.text = userList[position].email
        Glide.with(mCtx).load(userList[position].avatar).into(holder.imageView)
    }



    override fun getItemCount(): Int {
        return userList.size
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val imageView:ImageView = itemView.findViewById(R.id.image)
        val user_name:TextView = itemView.findViewById(R.id.user_name)
        val user_email:TextView = itemView.findViewById(R.id.email)
    }
}