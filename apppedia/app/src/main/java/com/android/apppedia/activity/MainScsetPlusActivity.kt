package com.android.apppedia.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
import kotlinx.android.synthetic.main.activity_main_scset_plus.*

class MainScsetPlusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_scset_plus)

        var key_category: String? = "Video Players"
        val adapter_category = ArrayAdapter.createFromResource(this, R.array.spinnerArray, android.R.layout.simple_spinner_item)
        spinner_category.adapter = adapter_category
        spinner_category.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(AdapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                key_category = setCategory(position)
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
                key_category = App.prefs.CATEGORY
            }
        }

        //var key_developer: String? = "Google LLC"
        //val adapter_developer = ArrayAdapter.createFromResource(this, R.array.spinnerdev, android.R.layout.simple_spinner_item)
        //spinner_category.adapter = adapter_developer
        //spinner_category.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        //    override fun onItemSelected(AdapterView: AdapterView<*>, view: View, position: Int, l: Long) {
        //        key_category = setCategory(position)
        //    }
        //    override fun onNothingSelected(adapterView: AdapterView<*>?) {
        //    }
        //}

        var key_f5: String? = "FIRST"
        val adapter_f5 = ArrayAdapter.createFromResource(this, R.array.spinnerfunction, android.R.layout.simple_spinner_item)
        spinner_function_five.adapter = adapter_f5
        spinner_function_five.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(AdapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                key_f5 = setFunction(position)
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
                key_f5 = App.prefs.FUNCTION_FIVE
            }
        }

        var key_f4: String? = "SECOND"
        val adapter_f4 = ArrayAdapter.createFromResource(this, R.array.spinnerfunction, android.R.layout.simple_spinner_item)
        spinner_function_four.adapter = adapter_f4
        spinner_function_four.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(AdapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                key_f4 = setFunction(position)
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
                key_f4 = App.prefs.FUNCTION_FOUR
            }
        }

        var key_f3: String? = "THIRD"
        val adapter_f3 = ArrayAdapter.createFromResource(this, R.array.spinnerfunction, android.R.layout.simple_spinner_item)
        spinner_function_three.adapter = adapter_f3
        spinner_function_three.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(AdapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                key_f3 = setFunction(position)
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        }

        var key_f2: String? = "FORTH"
        val adapter_f2 = ArrayAdapter.createFromResource(this, R.array.spinnerfunction, android.R.layout.simple_spinner_item)
        spinner_function_two.adapter = adapter_f2
        spinner_function_two.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(AdapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                key_f2 = setFunction(position)
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        }

        var key_f1: String? = "FIFTH"
        val adapter_f1 = ArrayAdapter.createFromResource(this, R.array.spinnerfunction, android.R.layout.simple_spinner_item)
        spinner_function_one.adapter = adapter_f1
        spinner_function_one.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(AdapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                key_f1 = setFunction(position)
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        }

        iv_cancel.setOnClickListener {
            val intent = Intent(this, MainScsetActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_scset_finish.setOnClickListener {
            App.prefs.CATEGORY = key_category.toString()
            App.prefs.FUNCTION_FIVE = key_f5.toString()
            App.prefs.FUNCTION_FOUR = key_f4.toString()
            App.prefs.FUNCTION_THREE = key_f3.toString()
            App.prefs.FUNCTION_TWO = key_f2.toString()
            App.prefs.FUNCTION_ONE = key_f1.toString()
            if (et_rating_lower_total.text.toString() != "") App.prefs.RATING_TOTAL_LOWER = et_rating_lower_total.text.toString()
            if (et_rating_upper_total.text.toString() != "") App.prefs.RATING_TOTAL_UPPER = et_rating_upper_total.text.toString()
            if (et_rating_lower_average.text.toString() != "") App.prefs.RATING_AVERAGE_LOWER = et_rating_lower_average.text.toString()
            if (et_rating_upper_average.text.toString() != "") App.prefs.RATING_AVERAGE_UPPER = et_rating_upper_average.text.toString()
            if (et_install_lower.text.toString() != "") App.prefs.INSTALL_LOWER = et_install_lower.text.toString()
            if (et_install_upper.text.toString() != "") App.prefs.INSTALL_UPPER = et_install_upper.text.toString()
            if (et_price_lower.text.toString() != "") App.prefs.PRICE_LOWER = et_price_lower.text.toString()
            if (et_price_upper.text.toString() != "") App.prefs.PRICE_UPPER = et_price_upper.text.toString()
            if (et_version_needs.text.toString() != "") App.prefs.VERSION_NEEDS = et_version_needs.text.toString()

            val intent = Intent(this, MainScsetActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun setCategory(position: Int) =
        when (position) {
            0 ->  "Art & Design"
            1 ->  "Auto & Vehicles"
            2 ->  "Beauty"
            3 ->  "Books & Reference"
            4 ->  "Business"
            5 ->  "Comics"
            6 ->  "Communication"
            7 ->  "Dating"
            8 ->  "Education"
            9 ->  "Entertainment"
            10 ->  "Events"
            11 ->  "Finance"
            12 ->  "Food & Drink"
            13 ->  "Health & Fitness"
            14 ->  "House & Home"
            15 ->  "Libraries & Demo"
            16 ->  "Lifestyle"
            17 ->  "Maps & Navigation"
            18 ->  "Medical"
            19 ->  "Music & Audio"
            20 ->  "News & Magazines"
            21 ->  "Parenting"
            22 ->  "Personalization"
            23 ->  "Photography"
            24 ->  "Productivity"
            25 ->  "Shopping"
            26 ->  "Social"
            27 ->  "Sports"
            28 ->  "Tools"
            29 ->  "Travel & Local"
            30 ->  "Video Players"
            31 ->  "Weather"
            32 ->  "Game Action"
            33 ->  "Game Adventure"
            34 ->  "Game Arcade"
            35 ->  "Game Board"
            36 ->  "Game Card"
            37 ->  "Game Casino"
            38 ->  "Game Casual"
            39 ->  "Game Educational"
            40 ->  "Game Music"
            41 ->  "Game Puzzle"
            42 ->  "Game Racing"
            43 ->  "Game Role Playing"
            44 ->  "Game Simulation"
            45 ->  "Game Sports"
            46 ->  "Game Strategy"
            47 ->  "Game Trivia"
            48 ->  "Game Word"
            else -> null
        }

    fun setFunction(position: Int) =
        when (position) {
            0 -> "메일"
            1 -> "예술"
            2 -> "디자인"
            3 -> "자동차"
            4 -> "뷰티"
            5 -> "패션"
            6 -> "옷"
            7 -> "책"
            8 -> "비즈니스"
            9 -> "만화"
            10 -> "딜리버리"
            11 -> "커뮤니케이션"
            12 -> "교육"
            13 -> "엔터테인먼트"
            14 -> "경제"
            15 -> "금융"
            16 -> "경영"
            17 -> "음식"
            18 -> "헬스"
            19 -> "건강"
            20 -> "운동"
            21 -> "스포츠"
            22 -> "피트니스"
            23 -> "도서"
            24 -> "독서"
            25 -> "인테리어"
            26 -> "라이프스타일"
            27 -> "라이프"
            28 -> "맵"
            29 -> "지도"
            30 -> "GPS"
            31 -> "네비게이션"
            32 -> "음악"
            33 -> "노래"
            34 -> "의료"
            35 -> "뉴스"
            36 -> "매거진"
            37 -> "잡지"
            38 -> "포토"
            39 -> "사진"
            40 -> "동영상"
            41 -> "영상"
            42 -> "채널"
            43 -> "위치"
            44 -> "생산"
            45 -> "쇼핑"
            46 -> "소셜"
            47 -> "미디어"
            48 -> "여행"
            49 -> "비디오"
            50 -> "게임"
            51 -> "날씨"
            52 -> "미용"
            53 -> "음성인식"
            54 -> "타투"
            55 -> "코딩"
            56 -> "메모"
            57 -> "메모장"
            58 -> "필터"
            59 -> "카메라"
            60 -> "계산기"
            61 -> "시계"
            62 -> "시간표"
            63 -> "배달"
            64 -> "음식"
            65 -> "영화"
            66 -> "카페"
            67 -> "중고"
            68 -> "쇼핑몰"
            69 -> "코로나"
            70 -> "알바"
            71 -> "교통"
            72 -> "대중교통"
            73 -> "문자"
            74 -> "메세지"
            75 -> "캘린더"
            76 -> "켈린"
            77 -> "티비"
            78 -> "TV"
            else -> null
        }
}