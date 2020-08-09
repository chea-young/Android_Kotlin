package com.cheayoung.androidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() { // 앱이 최초 실행했을 때 수행.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // xml 화면 뷰를 연결
        tv_title.setText("Hello...") //text의 값을 변경
    }
}