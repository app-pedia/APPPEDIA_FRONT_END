package com.android.apppedia.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.apppedia.R
import com.android.apppedia.Adapter.ApplicationListAdapter
import com.android.apppedia.api.ApppediaApi
import com.android.apppedia.api.NetworkCore
import com.android.apppedia.data.Application_Rslt
import com.android.apppedia.data.Application_Srch
import com.android.apppedia.repository.App
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_search_list.*

class SearchListActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)

        val Search = intent.getStringExtra("Search")

        var list: ArrayList<Application_Rslt>

        val requestapplicationsrch = Application_Srch(
                Search.toString(),
                App.prefs.CATEGORY.toString(),
                App.prefs.DEVELOPER.toString(),
                App.prefs.RATING_TOTAL_UPPER.toString(),
                App.prefs.RATING_TOTAL_LOWER.toString(),
                App.prefs.RATING_AVERAGE_UPPER.toString(),
                App.prefs.RATING_AVERAGE_LOWER.toString(),
                App.prefs.INSTALL_UPPER.toString(),
                App.prefs.INSTALL_LOWER.toString(),
                App.prefs.PRICE_UPPER.toString(),
                App.prefs.PRICE_LOWER.toString(),
                App.prefs.VERSION_NEEDS.toString(),
                App.prefs.FUNCTION_FIVE.toString(),
                App.prefs.FUNCTION_FOUR.toString(),
                App.prefs.FUNCTION_THREE.toString(),
                App.prefs.FUNCTION_TWO.toString(),
                App.prefs.FUNCTION_ONE.toString()
        )
        NetworkCore.getNetworkCore<ApppediaApi>()
            .requestApplicationSrch(
                    App.prefs.TOKEN.toString(),
                    requestapplicationsrch
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                list = response
                val adapter = ApplicationListAdapter(list, this@SearchListActivity)
                rv_application_list.adapter = adapter
                rv_application_list.addItemDecoration(
                        DividerItemDecoration(
                                this,
                                DividerItemDecoration.VERTICAL
                        )
                )
                rv_application_list.layoutManager = LinearLayoutManager(this@SearchListActivity)

            }, { except ->
                Log.d("error",except.toString())
            })

        iv_cancel.setOnClickListener {
            finish()
        }
    }
}