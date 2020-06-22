package com.android.apppedia.fragment

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.apppedia.Adapter.FunctionListAdapter
import com.android.apppedia.R
import com.android.apppedia.api.ApppediaApi
import com.android.apppedia.api.NetworkCore
import com.android.apppedia.data.Functionss
import com.android.apppedia.repository.App
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.dialog_function.*

class FunctionInfoFragment(context: Context, val public_id: String?): Dialog(context){
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_function)

        var list: ArrayList<Functionss>

        NetworkCore.getNetworkCore<ApppediaApi>()
                .requestFunctionList(
                        App.prefs.TOKEN.toString(),
                        public_id.toString()
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    list = response
                    val adapter = FunctionListAdapter(list, context)
                    rv_function_list.adapter = adapter
                    rv_function_list.addItemDecoration(
                            DividerItemDecoration(
                                    context,
                                    DividerItemDecoration.VERTICAL
                            )
                    )
                    rv_function_list.layoutManager = LinearLayoutManager(context)

                }, { except ->
                    Log.d("error",except.toString())
                })

        iv_cancel.setOnClickListener {
            dismiss()
        }
    }
}