package com.cheayoung.androidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_custom_listview.*

class CustomListviewActivity : AppCompatActivity() {
    var UserList = arrayListOf<User>(
        User(R.drawable.robot_list, "이름", "나이", "안녕하세요"),
        User(R.drawable.robot_list, "사과", "나이", "안녕하세요"),
        User(R.drawable.robot_list, "이름", "나이", "안녕하세요"),
        User(R.drawable.robot_list, "이름", "1", "안녕하세요"),
        User(R.drawable.robot_list, "이름", "2", "안녕하세요"),
        User(R.drawable.robot_list, "이름", "3", "안녕하세요"),
        User(R.drawable.robot_list, "이름", "4", "안녕하세요")

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_listview)

        val Adapter = UserAdapter(this, UserList)
        listView_custom.adapter = Adapter

        listView_custom.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }

        button_recycler.setOnClickListener {
            val intent = Intent(this, RecyclerActivity::class.java)// 다음 화면으로 이동
            startActivity(intent)
            finish()
        }

    }
}