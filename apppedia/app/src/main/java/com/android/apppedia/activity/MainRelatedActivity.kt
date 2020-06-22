package com.android.apppedia.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.apppedia.R
import com.android.apppedia.Adapter.RelatedListAdapter
import com.android.apppedia.api.ApppediaApi
import com.android.apppedia.api.NetworkCore
import com.android.apppedia.data.Application_Plus
import com.android.apppedia.repository.App
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main_related.*

class MainRelatedActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_related)

        tv_user_email.text = App.prefs.EMAIL
        App.prefs.BEFORE = '2'.toString()

        var list: ArrayList<Application_Plus>

        NetworkCore.getNetworkCore<ApppediaApi>()
            .requestApplicationPlus(
                    App.prefs.TOKEN.toString(),
                    App.prefs.CATEGORY.toString()
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                list = response
                val adapter = RelatedListAdapter(list, this@MainRelatedActivity)
                rv_related.adapter = adapter
                rv_related.addItemDecoration(
                        DividerItemDecoration(
                                this,
                                DividerItemDecoration.VERTICAL
                        )
                )
                rv_related.layoutManager = LinearLayoutManager(this@MainRelatedActivity)
            }, { except ->
                Log.d("error",except.toString())
            })

        et_search.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
            finish()
        }

        iv_menu.setOnClickListener {
            if (!drawer.isDrawerOpen(Gravity.LEFT)) {
                drawer.openDrawer(Gravity.LEFT)
            }
        }

        drawer_favorites.setOnClickListener {
            val intent = Intent(this, MainFavoritesActivity::class.java)
            startActivity(intent)
            finish()
        }

        drawer_search_setting.setOnClickListener {
            val intent = Intent(this, MainScsetActivity::class.java)
            startActivity(intent)
            finish()
        }

        drawer_mypage.setOnClickListener {
            //val intent = Intent(this, MyPageActivity::class.java)
            //intent.putExtra("UserEmail", UserEmail)
            //startActivity(intent)
            //finish()
        }

        drawer_setting.setOnClickListener {
            //val intent = Intent(this, SettingActivity::class.java)
            //intent.putExtra("UserEmail", UserEmail)
            //startActivity(intent)
            //finish()
        }

        drawer_support.setOnClickListener {
            //val intent = Intent(this, SuppportActivity::class.java)
            //intent.putExtra("UserEmail", UserEmail)
            //startActivity(intent)
            //finish()
        }

        drawer_logout.setOnClickListener {
            val intent = Intent(this, StartLogInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}