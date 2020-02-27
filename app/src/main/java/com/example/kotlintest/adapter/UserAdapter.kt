package com.example.kotlintest.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.kotlintest.R
import com.example.kotlintest.activity.detail.view.Detail
import com.example.kotlintest.model.main.User

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewholder>(), View.OnClickListener {

    private lateinit var list: List<User>
    private val listener: View.OnClickListener? = null

    fun userAdapter(modelList: List<User>?){
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
        holder.nombreUsuarioTxt.text = this.list[position].name
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, Detail::class.java)
            it.context.startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        listener?.onClick(v)
    }

    class UserViewholder(view: View): RecyclerView.ViewHolder(view){

        var unbinder: Unbinder = ButterKnife.bind(this, view)

        @BindView(R.id.nombre_usuario_txt)
        lateinit var nombreUsuarioTxt: TextView
    }
}