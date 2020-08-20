package com.cheayoung.androidkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter (val profileList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder> ()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        //화면을 붙인다.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition
                val profile: Profiles = profileList.get(curPos)
                Toast.makeText(parent.context, "이름 : ${profile.name}\n 나이 : ${profile.age}\n 직업: ${profile.job}", Toast.LENGTH_SHORT).show()


            }

        }

    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //만들어진 뷰를 연결해주는거 오는 데이터를 계속적으로 매치 시켜주는거
        holder.gender.setImageResource(profileList.get(position).gender)// position은 현재 위치
        holder.name.text = profileList.get(position).name
        holder.age.text = profileList.get(position).age.toString()
        holder.job.text = profileList.get(position).job

    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile) // 특정 xml에서 찾아올 수 있다.
        val name = itemView.findViewById<TextView>(R.id.user_name)
        val age = itemView.findViewById<TextView>(R.id.user_age)
        val job = itemView.findViewById<TextView>(R.id.user_job)

    }

}