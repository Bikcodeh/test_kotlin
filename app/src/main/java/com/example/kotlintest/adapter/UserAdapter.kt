package com.example.kotlintest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.kotlintest.R
import com.example.kotlintest.model.main.User

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewholder>() {

    lateinit var list: List<User>

    fun UserAdapter(modelList: List<User>?){
        if (modelList != null) {
           list = ArrayList(modelList)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewholder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewholder(view)
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    override fun onBindViewHolder(holder: UserViewholder, position: Int) {
        holder.nombre_usuario_txt.text = this.list[position].name
    }

    class UserViewholder(view: View): RecyclerView.ViewHolder(view){

        var unbinder: Unbinder = ButterKnife.bind(this, view)

        @BindView(R.id.nombre_usuario_txt)
        lateinit var nombre_usuario_txt: TextView
    }
}