package com.android.apppedia.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.apppedia.R
import com.android.apppedia.data.Auth
import com.android.apppedia.api.NetworkCore
import com.android.apppedia.api.ApppediaApi
import com.android.apppedia.repository.App
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_start_login.*
import retrofit2.HttpException

class StartLogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_login)

        btn_auth_login.isSelected = validateStep()

        btn_auth_login.setOnClickListener {
            if(btn_auth_login.isSelected){
                var requestauthlogin = Auth(et_auth_login_email.text.toString(), et_auth_login_password.text.toString())
                NetworkCore.getNetworkCore<ApppediaApi>()
                        .requestAuthLogIn(
                                requestauthlogin
                        )
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ response ->
                            App.prefs.TOKEN = response.Authorization
                            App.prefs.EMAIL = et_auth_login_email.text.toString()

                            if (App.prefs.MAIN.toString() == "1")
                            {
                                val intent = Intent(this@StartLogInActivity, MainFavoritesActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            //TODO MutableLiveData 처리
                            //isLogin.value = true
                        }, { except ->
                            if (except is HttpException){
                                if(except.code() == 401){
                                    Toast.makeText(this@StartLogInActivity, "로그인 정보가 없습니다.", Toast.LENGTH_SHORT).show()
                                }
                            }
                        })
            }
            else {
                Toast.makeText(this@StartLogInActivity, "아이디 또는 비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        et_auth_login_email.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                statusText(validateStep())
            }
        })

        et_auth_login_password.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                statusText(validateStep())
            }
        })

        btn_user_logup.setOnClickListener {
            val intent = Intent(this, StartLogUpActivity::class.java)
            startActivity(intent)
        }
    }

    fun statusText(boolean: Boolean) {
        btn_auth_login.isSelected = boolean
    }

    fun validateStep() : Boolean = et_auth_login_email.text.isNotEmpty() && et_auth_login_password.text.isNotEmpty()
}