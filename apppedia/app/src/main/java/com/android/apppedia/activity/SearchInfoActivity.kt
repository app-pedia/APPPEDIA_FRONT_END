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
import com.android.apppedia.fragment.FunctionInfoFragment
import com.android.apppedia.repository.App
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_search_info.*

class SearchInfoActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_info)

        val application_public_id = intent.getStringExtra("application_public_id")
        var application_developer_public_id = ""
        var application_install_link = ""
        var application_related_link = ""

        NetworkCore.getNetworkCore<ApppediaApi>()
            .requestApplicationInfo(
                    App.prefs.TOKEN.toString(),
                    application_public_id.toString()
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                tv_application_name.text = response.name
                tv_application_developer.text = response.developer_name
                application_developer_public_id = response.developer_public_id
                tv_application_category.text = response.category
                tv_application_rating_total.text = response.rating_total
                tv_application_rating_average.text = response.rating_average
                tv_application_rating_five.text = response.rating_five
                tv_application_rating_four.text = response.rating_four
                tv_application_rating_three.text = response.rating_three
                tv_application_rating_two.text = response.rating_two
                tv_application_rating_one.text = response.rating_one
                tv_application_install_achieved.text = response.install
                application_install_link = response.install_link
                Glide.with(this).load(response.image_logo).into(iv_application_logo);
                tv_application_price.text = response.price
                tv_application_update_date.text = response.update_date
                tv_application_size.text = response.size
                tv_application_version_current.text = response.version_current
                tv_application_version_needs.text = response.version_needs
                tv_application_contents_grade.text = response.contents_grade
                tv_application_interaction.text = response.interaction
                tv_application_in_app_products.text = response.in_app_products
                application_related_link = response.related_link
            }, { except ->
                Log.d("error",except.toString())
            })

        tv_application_developer.setOnClickListener {
            val intent = Intent(this, SearchDevActivity::class.java)
            intent.putExtra("public_id", application_developer_public_id)
            startActivity(intent)
        }

        tv_application_function.setOnClickListener {
            val functionInfoFragment = FunctionInfoFragment(this, application_public_id)
            functionInfoFragment.show()
        }

        tv_application_related.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(application_related_link))
            startActivity(intent)
        }

        btn_application_info_install.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(application_install_link))
            startActivity(intent)
        }

        iv_cancel.setOnClickListener {
            finish()
        }
    }
}