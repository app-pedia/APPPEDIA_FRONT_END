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
import kotlinx.android.synthetic.main.activity_main_scset.*

class MainScsetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_scset)

        tv_user_email.text = App.prefs.EMAIL
        App.prefs.BEFORE = '3'.toString()

        var list: ArrayList<Favorites_List>

        tv_category.text = App.prefs.CATEGORY.toString()
        tv_developer_name.text = App.prefs.DEVELOPER.toString()
        tv_rating_lower_total.text = App.prefs.RATING_TOTAL_LOWER.toString()
        tv_rating_upper_total.text = App.prefs.RATING_TOTAL_UPPER.toString()
        tv_rating_lower_average.text = App.prefs.RATING_AVERAGE_LOWER.toString()
        tv_rating_upper_average.text = App.prefs.RATING_AVERAGE_UPPER.toString()
        tv_install_lower.text = App.prefs.INSTALL_LOWER.toString()
        tv_install_upper.text = App.prefs.INSTALL_UPPER.toString()
        tv_price_lower.text = App.prefs.PRICE_LOWER.toString()
        tv_price_upper.text = App.prefs.PRICE_UPPER.toString()
        tv_version_needs.text = App.prefs.VERSION_NEEDS.toString()
        tv_function_five.text = App.prefs.FUNCTION_FIVE.toString()
        tv_function_four.text = App.prefs.FUNCTION_FOUR.toString()
        tv_function_three.text = App.prefs.FUNCTION_THREE.toString()
        tv_function_two.text = App.prefs.FUNCTION_TWO.toString()
        tv_function_one.text = App.prefs.FUNCTION_ONE.toString()

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

        drawer_related.setOnClickListener {
            val intent = Intent(this, MainRelatedActivity::class.java)
            startActivity(intent)
            finish()
        }

        drawer_mypage.setOnClickListener {
            //val intent = Intent(this, MyPageActivity::class.java)
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

        drawer_setting.setOnClickListener {
            //val intent = Intent(this, SettingActivity::class.java)
            //intent.putExtra("UserEmail", UserEmail)
            //startActivity(intent)
            //finish()
        }

        drawer_logout.setOnClickListener {
            val intent = Intent(this, StartLogInActivity::class.java)
            startActivity(intent)
            finish()
        }

        fab_plus.setOnClickListener {
            val intent = Intent(this, MainScsetPlusActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}