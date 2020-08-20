package com.cheayoung.androidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_custom_listview.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val profileList = arrayListOf(
            Profiles(R.drawable.man_user, "사과", 10, "직업"),
            Profiles(R.drawable.woman_user, "토마토", 3, "직업"),
            Profiles(R.drawable.man_user, "배", 1, "직업"),
            Profiles(R.drawable.woman_user, "복숭아", 2, "직업"),
            Profiles(R.drawable.woman_user, "자두", 15, "직업"),
            Profiles(R.drawable.woman_user, "체리", 9, "직업"),
            Profiles(R.drawable.man_user, "파인애플", 20, "직업"),
            Profiles(R.drawable.woman_user, "무화과", 18, "직업"),
            Profiles(R.drawable.man_user, "딸기", 5, "직업"),
            Profiles(R.drawable.woman_user, "수박", 8, "직업"),
            Profiles(R.drawable.man_user, "망고", 6, "직업"),
            Profiles(R.drawable.woman_user, "키위", 19, "직업"),
            Profiles(R.drawable.man_user, "귤", 14, "직업"),
            Profiles(R.drawable.man_user, "오렌지", 7, "직업"),
            Profiles(R.drawable.woman_user, "애플망고", 16, "직업"),
            Profiles(R.drawable.man_user, "포도", 12, "직업"),
            Profiles(R.drawable.man_user, "바나나", 11, "직업"),
            Profiles(R.drawable.man_user, "레몬", 17, "직업"),
            Profiles(R.drawable.woman_user, "블루베리", 13, "직업")

        )
        rv_profile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_profile.setHasFixedSize(true)

        rv_profile.adapter = ProfileAdapter(profileList)


    }


}