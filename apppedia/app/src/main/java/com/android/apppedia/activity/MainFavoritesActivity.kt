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
import com.android.apppedia.Adapter.FavoritesListAdapter
import com.android.apppedia.api.ApppediaApi
import com.android.apppedia.api.NetworkCore
import com.android.apppedia.data.Favorites_List
import com.android.apppedia.repository.App
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main_favorites.*

class MainFavoritesActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_favorites)

        tv_user_email.text = App.prefs.EMAIL
        App.prefs.BEFORE = '1'.toString()

        App.prefs.VS_FIVE = "string"
        App.prefs.VS_FOUR = "string"
        App.prefs.VS_THREE = "string"
        App.prefs.VS_TWO = "string"
        App.prefs.VS_ONE = "string"

        var list: ArrayList<Favorites_List>

        NetworkCore.getNetworkCore<ApppediaApi>()
            .requestFavoritesList(
                    App.prefs.TOKEN.toString(),
                    App.prefs.EMAIL.toString()
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                list = response
                val adapter = FavoritesListAdapter(list, this@MainFavoritesActivity)
                rv_favorites.adapter = adapter
                rv_favorites.addItemDecoration(
                        DividerItemDecoration(
                                this,
                                DividerItemDecoration.VERTICAL
                        )
                )
                rv_favorites.layoutManager = LinearLayoutManager(this@MainFavoritesActivity)
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

        drawer_related.setOnClickListener {
            val intent = Intent(this, MainRelatedActivity::class.java)
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
            //startActivity(intent)
            //finish()
        }

        drawer_setting.setOnClickListener {
            //val intent = Intent(this, SettingActivity::class.java)
            //startActivity(intent)
            //finish()
        }

        drawer_support.setOnClickListener {
            //val intent = Intent(this, SuppportActivity::class.java)
            //startActivity(intent)
            //finish()
        }

        drawer_logout.setOnClickListener {
            val intent = Intent(this, StartLogInActivity::class.java)
            startActivity(intent)
            finish()
        }

        fab_versus.setOnClickListener {
            val intent = Intent(this, MainFavoritesVsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}