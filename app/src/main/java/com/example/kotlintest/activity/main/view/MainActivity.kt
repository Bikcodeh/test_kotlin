package com.example.kotlintest.activity.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.kotlintest.R
import com.example.kotlintest.activity.main.presenter.MainPresenter
import com.example.kotlintest.adapter.UserAdapter
import com.example.kotlintest.model.main.User

class MainActivity: MainActivityImpl, AppCompatActivity() {

    @BindView(R.id.recycler_list)
    lateinit var recyclerList: RecyclerView

    @BindView(R.id.progress_bar)
    lateinit var progressBar: ProgressBar

    var userAdapter: UserAdapter = UserAdapter()
    lateinit var layoutManager: LinearLayoutManager

    val presenter: MainPresenter = MainPresenter(this)

    @OnClick(R.id.btn_search)
    internal fun search(){
        //Toast.makeText(this, "Hola mundo", Toast.LENGTH_SHORT).show()
        presenter.getUsers()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()

    }

    private fun initComponents(){
        ButterKnife.bind(this)
        this.layoutManager = LinearLayoutManager(this)
        this.layoutManager.orientation = RecyclerView.VERTICAL
    }

    override fun showProgress() {
        this.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        this.progressBar.visibility = View.INVISIBLE
    }

    override fun setDataToRecycler(user: List<User>?) {
        recyclerList.layoutManager = this.layoutManager
        recyclerList.setHasFixedSize(true)
        userAdapter.UserAdapter(user)
        recyclerList.adapter = userAdapter
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
    }
}
