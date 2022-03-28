package com.example.giuaki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var userList: ArrayList<User> = ArrayList()
    private var onClickItem: ((User) -> Unit)? = null
    private var onClickDeleteItem: ((User) -> Unit)? = null

    fun addItems(items: ArrayList<User>) {
        this.userList = items
        notifyDataSetChanged()
    }

    fun setOnClickItem(callback: (User) -> Unit) {
        this.onClickItem = callback
    }

    fun setOnClickDeleteitem(callback: (User) -> Unit) {
        this.onClickDeleteItem = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder(inflater.inflate(R.layout.card_items_user, parent, false))

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bindView(user)
        holder.itemView.setOnClickListener { onClickItem?.invoke(user) }
        holder.btnDelete.setOnClickListener { onClickDeleteItem?.invoke(user) }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        private var id = view.findViewById<TextView>(R.id.tvId)
        private var name = view.findViewById<TextView>(R.id.tvName)
        private var email = view.findViewById<TextView>(R.id.tvEmail)
        private var phonenumber = view.findViewById<TextView>(R.id.tvPhoneNumber)
        private var address = view.findViewById<TextView>(R.id.tvAddress)
        var btnDelete = view.findViewById<Button>(R.id.btnDelete)

        fun bindView(user: User) {
            id.text = user.id.toString()
            name.text = user.name
            email.text = user.email
            phonenumber.text = user.phonenumber
            address.text = user.address

        }
    }
}