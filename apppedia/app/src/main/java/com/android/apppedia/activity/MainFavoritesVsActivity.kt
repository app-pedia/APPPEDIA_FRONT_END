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
import com.android.apppedia.Adapter.FavoritesVsAdapter
import com.android.apppedia.api.ApppediaApi
import com.android.apppedia.api.NetworkCore
import com.android.apppedia.data.Favorites_List
import com.android.apppedia.repository.App
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main_favorites_vs.*

class MainFavoritesVsActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_favorites_vs)

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
                val adapter = FavoritesVsAdapter(list, this@MainFavoritesVsActivity)
                rv_favorites.adapter = adapter
                rv_favorites.addItemDecoration(
                        DividerItemDecoration(
                                this,
                                DividerItemDecoration.VERTICAL
                        )
                )
                rv_favorites.layoutManager = LinearLayoutManager(this@MainFavoritesVsActivity)
            }, { except ->
                Log.d("error",except.toString())
            })

        iv_cancel.setOnClickListener {
            val intent = Intent(this, MainFavoritesActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_scset_finish.setOnClickListener {
            val intent = Intent(this, MainFavoritesVsResultActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}