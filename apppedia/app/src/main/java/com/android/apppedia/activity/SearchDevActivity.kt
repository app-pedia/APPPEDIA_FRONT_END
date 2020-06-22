package com.android.apppedia.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.apppedia.R
import com.android.apppedia.api.ApppediaApi
import com.android.apppedia.api.NetworkCore
import com.android.apppedia.repository.App
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_search_dev.*

class SearchDevActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_dev)

        val public_id = intent.getStringExtra("public_id")

        var developer_web = ""

        NetworkCore.getNetworkCore<ApppediaApi>()
            .requestDeveloperInfo(
                    App.prefs.TOKEN.toString(),
                    public_id.toString()
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                tv_developer_name.text = response.name
                tv_developer_country.text = response.country
                tv_developer_address.text = response.address
                developer_web = response.web
                tv_developer_rating_total.text = response.rating_total
                tv_developer_rating_average.text = response.rating_average
                tv_developer_install_achieved.text = response.install_achieved
            }, { except ->
                Log.d("error",except.toString())
            })

        tv_developer_web.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(developer_web))
            startActivity(intent)
        }

        iv_cancel.setOnClickListener {
            finish()
        }
    }
}