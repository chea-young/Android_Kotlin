package com.cheayoung.androidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_list.button_next

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val item = arrayOf("사과", "체리", "파인애플")
        //context는 한 액티비티에 들어있는 모든 정보
        listView_custom.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

        button_next.setOnClickListener {
            //var : 변수
            //val:  값이 변경되지 못 하는 변수
            val intent = Intent(this, CustomListviewActivity::class.java)// 다음 화면으로 이동
            startActivity(intent)
            finish()
        }
    }
}