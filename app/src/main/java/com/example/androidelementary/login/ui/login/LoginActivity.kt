package com.example.androidelementary.login.ui.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidelementary.R
import com.example.androidelementary.utils.StatusBarUtil
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

const val TAG = "LoginActivity"

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        StatusBarUtil.changeStatusBarTransparent(this)
        val maxMemory = (Runtime.getRuntime().maxMemory() * 1.0 / (1024 * 1024)).toFloat()
        Log.d(TAG, "onCreate: $maxMemory")
        Observable.create { e: ObservableEmitter<Any> ->
            var i = 0
            while (true) {
                e.onNext(i)
                i++
            }
        }.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { i: Any ->
                    Log.d("MyTag", i.toString())
                    Thread.sleep(1000)
                }
    }


}