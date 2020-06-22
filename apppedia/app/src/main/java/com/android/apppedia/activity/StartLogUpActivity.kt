package com.android.apppedia.activity

import android.os.Bundle
import android.os.Build;
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.apppedia.R
import com.android.apppedia.api.ApppediaApi
import com.android.apppedia.api.NetworkCore
import com.android.apppedia.data.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_start_logup.*
import retrofit2.HttpException

//TODO 필수 작성 항목 UI 표현

class StartLogUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_logup)

        btn_user_logup_finish.isSelected = validateStep()

        tv_user_logup_device_name.text = Build.MODEL;
        tv_user_logup_android_version.text = Build.VERSION.RELEASE;

        btn_user_logup_finish.setOnClickListener{
            if(btn_user_logup_finish.isSelected){
                if(et_user_logup_password.text.toString().length >= 8 && et_user_logup_password.text.toString().length <= 16) {
                    if(et_user_logup_password.text.toString() == et_user_logup_repassword.text.toString()){
                        var requestuserlogup = User(
                            et_user_logup_email.text.toString(),
                            et_user_logup_username.text.toString(),
                            et_user_logup_password.text.toString(),
                            tv_user_logup_device_name.text.toString(),
                            tv_user_logup_android_version.text.toString()
                        )
                        NetworkCore.getNetworkCore<ApppediaApi>()
                            .requestUserLogUp(
                                requestuserlogup
                            )
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({
                                Log.d("Register Success", it.toString())
                                finish()
                            }, { except ->
                                if (except is HttpException){
                                    if(except.code() == 409){
                                        Toast.makeText(this@StartLogUpActivity, "중복된 이메일이 존재합니다", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            })
                    }
                    else{
                        Toast.makeText(this@StartLogUpActivity, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this@StartLogUpActivity, "비밀번호 자릿수를 확인하세요", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this@StartLogUpActivity, "필요한 정보를 모두 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        iv_cancel.setOnClickListener {
            finish()
        }

        et_user_logup_email.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                statusText(validateStep())
            }
        })

        et_user_logup_username.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                statusText(validateStep())
            }
        })

        et_user_logup_password.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                statusText(validateStep())
            }
        })

        et_user_logup_repassword.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                statusText(validateStep())
            }
        })
    }

    fun statusText(boolean: Boolean) {
        btn_user_logup_finish.isSelected = boolean
    }

    fun validateStep() : Boolean = et_user_logup_email.text.isNotEmpty() &&
            et_user_logup_username.text.isNotEmpty() &&
            et_user_logup_password.text.isNotEmpty() &&
            et_user_logup_repassword.text.isNotEmpty() &&
            tv_user_logup_device_name.text.isNotEmpty() &&
            tv_user_logup_android_version.text.isNotEmpty()
}