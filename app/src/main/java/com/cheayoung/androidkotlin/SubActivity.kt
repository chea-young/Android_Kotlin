package com.cheayoung.androidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    var a: Int =0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        if(intent.hasExtra("msg")){
            textView.text = intent.getStringExtra("msg")
            //서브 액티비티의 존재하는 텍스트뷰에다가 text가 넘겨져 온다.
        }
        button_toast.setOnClickListener {
            iv_profile.setImageResource(R.drawable.robot_1) //R이 res
            Toast.makeText(this@SubActivity, "버튼이 클릭 되었습니다.", Toast.LENGTH_SHORT).show()
        }
        a=2
        Log.d("로그 테스트", "OK") // logcat에서 debug로 뜬다.
        Log.d("var a의 현재 변수 값", a.toString()) //a가 int형이라서 toString()을 하는 것이다.
        Log.e("else if 문", "Error") //빨간색으로 나와서 로그를 직관적으로 볼 수 있지만 에러를 일으키는 것이기 때문에 쓰고 지우기!
    }
}