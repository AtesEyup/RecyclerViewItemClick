package com.example.testappone.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testappone.Models.UserInfoModel
import com.example.testappone.R


class UserAdapter(private val UserList: List<UserInfoModel>,private val click:IUserAdapterClick) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtUserName: TextView = itemView.findViewById(R.id.item_txtInfo)
        val rootView=itemView.rootView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = UserList[position]
        holder.txtUserName.text = data.Name
        holder.rootView.setOnClickListener {
         click.onUserClick(position,data)
        }
    }

    override fun getItemCount(): Int {
        return UserList.size
    }
}

interface IUserAdapterClick{
    fun onUserClick(position:Int,data:UserInfoModel)
}