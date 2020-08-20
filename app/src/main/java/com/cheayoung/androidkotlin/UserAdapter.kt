package com.cheayoung.androidkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

// 이거를 호출하면서 리스트 뷰를 계속 생성한다.
class UserAdapter (val context: Context, val UserList: ArrayList<User>):BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user, null)
        val profile = view.findViewById<ImageView>(R.id.iv_profile)
        val name = view.findViewById<TextView>(R.id.user_name)
        val greet = view.findViewById<TextView>(R.id.tv_greet)
        val age = view.findViewById<TextView>(R.id.user_age)

        val user = UserList[position]
        profile.setImageResource((user.profile))
        name.text = user.name
        age.text = user.age
        greet.text = user.greet

        return view
    }

    override fun getItem(position: Int): Any {
        return UserList[position]

    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return UserList.size
    }
}
