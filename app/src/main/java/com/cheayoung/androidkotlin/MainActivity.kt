package com.cheayoung.androidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() { // 앱이 최초 실행했을 때 수행.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // xml 화면 뷰를 연결
        tv_title.setText("Hello...") //text의 값을 변경
        button_gettext.setOnClickListener {
            //텍스트에 입력되어있는 값을 가지고 와서 텍스트 뷰에 뿌려준다.
            var resultText = et_id.text.toString() //문자열 형태로 변화해서 가져오는 것
            tv_result.setText(resultText)
        }
    }
}