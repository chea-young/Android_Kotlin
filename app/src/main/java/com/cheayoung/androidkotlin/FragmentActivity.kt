package com.cheayoung.androidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        btn_fragment1.setOnClickListener {
            setFrag(0)
        }
        btn_fragment2.setOnClickListener {
            setFrag(1)
        }
        btn_fragment3.setOnClickListener {
            setFrag(2)
        }
    }

    private fun setFrag(frgNum : Int) {
        val ft = supportFragmentManager.beginTransaction()
        when(frgNum)
        {
             0 -> {
                 ft.replace(R.id.main_frame, Fragment1()).commit()
             }
            1 -> {
                ft.replace(R.id.main_frame, Fragment2()).commit()
            }
            2 -> {
                ft.replace(R.id.main_frame, Fragment3()).commit()
            }
        }
    }


}