package com.cheayoung.androidkotlin

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
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

        button_push.setOnClickListener{
            val NOTIFICATION_ID = 1001;
            createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT,
                false, getString(R.string.app_name), "App notification channel") // 1

            val channelId = "$packageName-${getString(R.string.app_name)}" // 2
            val title = "Android Developer"
            val content = "Notifications in Android P"

            val intent = Intent(baseContext, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            val pendingIntent = PendingIntent.getActivity(baseContext, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)    // 3

            val builder = NotificationCompat.Builder(this, channelId)  // 4
            builder.setSmallIcon(R.drawable.robot)    // 5
            builder.setContentTitle(title)    // 6
            builder.setContentText(content)    // 7
            builder.priority = NotificationCompat.PRIORITY_DEFAULT    // 8
            builder.setAutoCancel(true)   // 9
            builder.setContentIntent(pendingIntent)   // 10
            builder.setDefaults(Notification.DEFAULT_VIBRATE) // 진동음이 울리게 하는 것
            // 소리 알람은 DEFAULT_SOUND
            val notificationManager = NotificationManagerCompat.from(this)
            notificationManager.notify(NOTIFICATION_ID, builder.build())    // 11
        }
    }
    private fun createNotificationChannel(context: Context, importance: Int, showBadge: Boolean,
                                          name: String, description: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "${context.packageName}-$name"
            val channel = NotificationChannel(channelId, name, importance)
            channel.description = description
            channel.setShowBadge(showBadge)

            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
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
