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
import com.android.apppedia.data.Application_Comp
import com.android.apppedia.data.Application_Rult
import com.android.apppedia.data.Favorites_List
import com.android.apppedia.repository.App
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main_favorites_vs_result.*

class MainFavoritesVsResultActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_favorites_vs_result)

        var i = 0
        if (App.prefs.VS_ONE.toString() != "string") i = i + 1
        if (App.prefs.VS_TWO.toString() != "string") i = i + 1
        if (App.prefs.VS_THREE.toString() != "string") i = i + 1
        if (App.prefs.VS_FOUR.toString() != "string") i = i + 1
        if (App.prefs.VS_FIVE.toString() != "string") i = i + 1

        if (i > 1)
        {
            val requestapplicationcomp = Application_Comp(
                    App.prefs.VS_ONE.toString(),
                    App.prefs.FUNCTION_FIVE.toString(),
                    App.prefs.FUNCTION_FOUR.toString(),
                    App.prefs.FUNCTION_THREE.toString(),
                    App.prefs.FUNCTION_TWO.toString(),
                    App.prefs.FUNCTION_ONE.toString()
            )
            NetworkCore.getNetworkCore<ApppediaApi>()
                    .requestApplicationComp(
                            App.prefs.TOKEN.toString(),
                            requestapplicationcomp
                    )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                        Glide.with(this).load(response.image_logo).into(iv_application1_logo)
                        tv_application1_name.text = response.name
                        tv_application1_score.text = response.score_all
                        tv_application1_category.text = response.category
                    }, { except ->
                        Log.d("error",except.toString())
                    })
        }

        if (i > 2)
        {
            val requestapplicationcomp = Application_Comp(
                    App.prefs.VS_TWO.toString(),
                    App.prefs.FUNCTION_FIVE.toString(),
                    App.prefs.FUNCTION_FOUR.toString(),
                    App.prefs.FUNCTION_THREE.toString(),
                    App.prefs.FUNCTION_TWO.toString(),
                    App.prefs.FUNCTION_ONE.toString()
            )
            NetworkCore.getNetworkCore<ApppediaApi>()
                    .requestApplicationComp(
                            App.prefs.TOKEN.toString(),
                            requestapplicationcomp
                    )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                        Glide.with(this).load(response.image_logo).into(iv_application2_logo)
                        tv_application2_name.text = response.name
                        tv_application2_score.text = response.score_all
                        tv_application2_category.text = response.category
                    }, { except ->
                        Log.d("error",except.toString())
                    })
        }

        if (i > 3)
        {
            val requestapplicationcomp = Application_Comp(
                    App.prefs.VS_THREE.toString(),
                    App.prefs.FUNCTION_FIVE.toString(),
                    App.prefs.FUNCTION_FOUR.toString(),
                    App.prefs.FUNCTION_THREE.toString(),
                    App.prefs.FUNCTION_TWO.toString(),
                    App.prefs.FUNCTION_ONE.toString()
            )
            NetworkCore.getNetworkCore<ApppediaApi>()
                    .requestApplicationComp(
                            App.prefs.TOKEN.toString(),
                            requestapplicationcomp
                    )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                        Glide.with(this).load(response.image_logo).into(iv_application3_logo)
                        tv_application3_name.text = response.name
                        tv_application3_score.text = response.score_all
                        tv_application3_category.text = response.category
                    }, { except ->
                        Log.d("error",except.toString())
                    })
        }

        if (i > 4)
        {
            val requestapplicationcomp = Application_Comp(
                    App.prefs.VS_FOUR.toString(),
                    App.prefs.FUNCTION_FIVE.toString(),
                    App.prefs.FUNCTION_FOUR.toString(),
                    App.prefs.FUNCTION_THREE.toString(),
                    App.prefs.FUNCTION_TWO.toString(),
                    App.prefs.FUNCTION_ONE.toString()
            )
            NetworkCore.getNetworkCore<ApppediaApi>()
                    .requestApplicationComp(
                            App.prefs.TOKEN.toString(),
                            requestapplicationcomp
                    )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                        Glide.with(this).load(response.image_logo).into(iv_application4_logo)
                        tv_application4_name.text = response.name
                        tv_application4_score.text = response.score_all
                        tv_application4_category.text = response.category
                    }, { except ->
                        Log.d("error",except.toString())
                    })
        }

        if (i > 5)
        {
            val requestapplicationcomp = Application_Comp(
                    App.prefs.VS_FIVE.toString(),
                    App.prefs.FUNCTION_FIVE.toString(),
                    App.prefs.FUNCTION_FOUR.toString(),
                    App.prefs.FUNCTION_THREE.toString(),
                    App.prefs.FUNCTION_TWO.toString(),
                    App.prefs.FUNCTION_ONE.toString()
            )
            NetworkCore.getNetworkCore<ApppediaApi>()
                    .requestApplicationComp(
                            App.prefs.TOKEN.toString(),
                            requestapplicationcomp
                    )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                        Glide.with(this).load(response.image_logo).into(iv_application5_logo)
                        tv_application5_name.text = response.name
                        tv_application5_score.text = response.score_all
                        tv_application5_category.text = response.category
                    }, { except ->
                        Log.d("error",except.toString())
                    })
        }

        iv_cancel.setOnClickListener {
            val intent = Intent(this, MainFavoritesActivity::class.java)
            startActivity(intent)
            finish()
        }

        //iv_application1_logo.setOnClickListener {
        //    val intent = Intent(this, MainFavoritesActivity::class.java)
        //    startActivity(intent)
        //}
    }
}