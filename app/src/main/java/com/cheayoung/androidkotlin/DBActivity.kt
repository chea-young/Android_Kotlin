package com.cheayoung.androidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_d_b.*

class DBActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d_b)

        //TODU: 저장된 데이터를 로드
        loadData() //edit text 저장되어있던 값을 setText
    }

    private fun loadData() {
        val pref = getSharedPreferences("pref", 0)
        et_hello.setText((pref.getString("name", "")))// 1번재 인자에서는 저장할 당시의 키 값을 적어줌, 2번째 키 값에 데이터가 존재하지 않을 경우 대체


    }

    private fun saveData() {
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit() //수정모드
        edit.putString("name", et_hello.text.toString())// 1번재째 인자에는 키 값을, 2번째 인자에는 실제 담아둘 값
        edit.apply() // 값을 저장 완료
    }

    override fun onDestroy() { //해당 액티비티가가 종료되는 시이 다가올 때 호출
        super.onDestroy()
        saveData()// edit text 값을 저장
    }


}