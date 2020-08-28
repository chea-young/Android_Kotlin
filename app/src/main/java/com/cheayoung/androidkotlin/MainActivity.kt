package com.cheayoung.androidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_navi
import kotlinx.android.synthetic.main.activity_main.layout_drawer
import kotlinx.android.synthetic.main.activity_main.naviView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener { // 앱이 최초 실행했을 때 수행.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // xml 화면 뷰를 연결
        tv_title.setText("Hello...") //text의 값을 변경

        btn_navi.setOnClickListener{
            layout_drawer.openDrawer(GravityCompat.START)// START : left, END : right 랑 같은 말
        }
        naviView.setNavigationItemSelectedListener (this)

        button_gettext.setOnClickListener {
            //텍스트에 입력되어있는 값을 가지고 와서 텍스트 뷰에 뿌려준다.
            var resultText = et_id.text.toString() //문자열 형태로 변화해서 가져오는 것
            tv_result.setText(resultText)

        }

        button_next.setOnClickListener {
            //var : 변수
            //val:  값이 변경되지 못 하는 변수
            val intent = Intent(this, SubActivity::class.java)// 다음 화면으로 이동
            intent.putExtra("msg",tv_title.text.toString()) //msg라는 키로 잠겼다.
            startActivity(intent)
            finish()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId)
        {
            R.id.one -> {
                val intent = Intent(this, SubActivity::class.java)// 다음 화면으로 이동
                intent.putExtra("msg",tv_title.text.toString()) //msg라는 키로 잠겼다.
                startActivity(intent)
                finish()
                Toast.makeText(applicationContext, "서브 화면으로 이동", Toast.LENGTH_SHORT).show()
            }
            R.id.two -> {
                val intent = Intent(this, ListActivity::class.java)// 다음 화면으로 이동
                startActivity(intent)
                finish()
                Toast.makeText(applicationContext, "리스트뷰로 가기", Toast.LENGTH_SHORT).show()
            }
            R.id.three -> {
                val intent = Intent(this, DBActivity::class.java)// 다음 화면으로 이동
                startActivity(intent)
                finish()
                Toast.makeText(applicationContext, "DB 페이지로 이동", Toast.LENGTH_SHORT).show()
            }
            R.id.four -> {
                val intent = Intent(this, NavigationActivity::class.java)// 다음 화면으로 이동
                startActivity(intent)
                finish()
                Toast.makeText(applicationContext, "네비게이터뷰로 이동", Toast.LENGTH_SHORT).show()
            }
            R.id.five -> {
                val intent = Intent(this, WebSiteActivity::class.java)// 다음 화면으로 이동
                startActivity(intent)
                finish()
                Toast.makeText(applicationContext, "웹사이트뷰로 이동", Toast.LENGTH_SHORT).show()
            }
            R.id.six -> {
                val intent = Intent(this, FragmentActivity::class.java)// 다음 화면으로 이동
                startActivity(intent)
                finish()
                Toast.makeText(applicationContext, "프레그먼트뷰로 이동", Toast.LENGTH_SHORT).show()
            }
        }
        layout_drawer.closeDrawers()//펼쳐져있는데 네비게이션 drawer 메뉴를 닫아주라
        return false
    }

    override fun onBackPressed() {
        if(layout_drawer.isDrawerOpen(GravityCompat.START)) {
            layout_drawer.closeDrawers()
        }
        else {
            super.onBackPressed() //일단 백버튼 기능 실행
        }
    }
}
