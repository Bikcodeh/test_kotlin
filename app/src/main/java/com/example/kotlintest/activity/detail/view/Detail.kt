package com.example.kotlintest.activity.detail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.kotlintest.R
import com.example.kotlintest.activity.main.event.UserEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class Detail : AppCompatActivity() {

    @BindView(R.id.txt_bs)
    lateinit var txt_bs: TextView

    @BindView(R.id.txt_catchPhrase)
    lateinit var txt_catchPhrase: TextView

    @BindView(R.id.txt_city)
    lateinit var txt_city: TextView

    @BindView(R.id.txt_company)
    lateinit var txt_company: TextView

    @BindView(R.id.txt_email)
    lateinit var txt_email: TextView

    @BindView(R.id.txt_street)
    lateinit var txt_street: TextView

    @BindView(R.id.txt_username)
    lateinit var txt_username: TextView

    @BindView(R.id.txt_phone)
    lateinit var txt_phone: TextView

    @BindView(R.id.txt_suite)
    lateinit var txt_suite: TextView

    @BindView(R.id.txt_zip)
    lateinit var txt_zip: TextView

    @BindView(R.id.txt_website)
    lateinit var txt_website: TextView

    @BindView(R.id.txt_name)
    lateinit var txt_name: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        ButterKnife.bind(this)

        setSupportActionBar(findViewById(R.id.my_toolbar))
        title = resources.getString(R.string.title_detail_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)

    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(sticky = true)
    fun onEvent(userEvent: UserEvent){
        txt_name.text = (String.format("Name: %s", userEvent.user.name))
        txt_username.text = (String.format("Username: %s", userEvent.user.username))
        txt_email.text = (String.format("Email: %s", userEvent.user.email))
        txt_phone.text = (String.format("Phone: %s", userEvent.user.phone))
        txt_website.text = (String.format("Website: %s", userEvent.user.website))
        txt_street.text = (String.format("Stret: %s", userEvent.user.Address?.city))
        txt_city.text = (String.format("City: %s", userEvent.user.Address?.city))
        txt_suite.text = (String.format("Suite: %s", userEvent.user.Address?.suite))
        txt_zip.text = (String.format("Zip: %s", userEvent.user.Address?.zipCode))
        txt_company.text = (String.format("Company: %s", userEvent.user.Company?.name))
        txt_catchPhrase.text = (String.format("CatchPhrase: %s", userEvent.user.Company?.catchPhrase))
        txt_bs.text = (String.format("BS: %s", userEvent.user.Company?.bs))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
