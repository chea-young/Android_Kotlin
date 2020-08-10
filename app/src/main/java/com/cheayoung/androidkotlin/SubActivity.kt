package com.cheayoung.androidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
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
    }
}