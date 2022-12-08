package com.example.ch21_notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.ch21_notification.databinding.ActivityMainBinding

/**
 * Notification은 사용자가 메시지를 확인하거나 제거하기 전까지 메시지를 유지한다.
 * 메시지를 터치하면 지정된 Activity가 실행되어 애플리케이션 실행을 유도할 수 있다.
 * */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Notification Channel
         *
         * 8.0부터 추가된 기능
         * 이전 Notification은 하나의 알림을 끄면 해당 애플리케이션의 알림은 전부 차단됐었다.
         * 이러한 불편함으로 Channel을 나눠 알림 채널별로 관리할 수 있게 업데이트 되었다.
         * */

        binding.button.setOnClickListener {
            // Deprecated
//            setNotificationCompat()

            setNotificationChannel1()
        }

        binding.button2.setOnClickListener {
            setNotificationChannel2()
        }

        binding.button3.setOnClickListener {
            setNotificationChannel3()
        }

        binding.button4.setOnClickListener {
            setNotificationChannel4()
        }
    }

    private fun setNotificationCompat() {
        // Deprecated =================================================
        // It can activate Under Android8.0
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

        val builder = NotificationCompat.Builder(this)
            .setSmallIcon(android.R.drawable.ic_menu_search)
            .setLargeIcon(bitmap)
            .setContentTitle("Content Title")
            .setContentText("Content Text")

        val notification = builder.build()
        manager.notify(NOTI_ID_1, notification)
        // ============================================================
    }

    private fun setNotificationChannel1() {
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

        val builder1 = getNotificationBuilder(CHANNEL_1, "첫번째 채널")
            .setSmallIcon(android.R.drawable.ic_menu_search)
            .setLargeIcon(bitmap)
            .setNumber(100)         // 알림 메시지 안에 보여줄 숫자설정 ex> 미확인 메시지 수
            .setContentTitle("Content Title 1")
            .setContentText("Content Text 1")

        val notification = builder1.build()
        manager.notify(NOTI_ID_1, notification)
    }

    private fun setNotificationChannel2() {
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

        val builder2 = getNotificationBuilder(CHANNEL_1, "첫번째 채널")
            .setSmallIcon(android.R.drawable.ic_menu_search)
            .setLargeIcon(bitmap)
            .setNumber(100)         // 알림 메시지 안에 보여줄 숫자설정 ex> 미확인 메시지 수
            .setContentTitle("Content Title 2")
            .setContentText("Content Text 2")

        val notification = builder2.build()
        manager.notify(NOTI_ID_2, notification)
        // builder1과 ID가 같을경우 builder1의 알림이 온 상태에서
        // builder2의 알림은 새로 메시지를 띄우지 않고 알림창에서 builder1의 메시지가 지워지고 나타난다.
    }

    private fun setNotificationChannel3() {
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

        val builder1 = getNotificationBuilder(CHANNEL_2, "두번째 채널")
            .setSmallIcon(android.R.drawable.ic_menu_search)
            .setLargeIcon(bitmap)
            .setNumber(100)         // 알림 메시지 안에 보여줄 숫자설정 ex> 미확인 메시지 수
            .setContentTitle("Content Title 3")
            .setContentText("Content Text 3")

        val notification = builder1.build()
        manager.notify(NOTI_ID_3, notification)
    }

    private fun setNotificationChannel4() {
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

        val builder1 = getNotificationBuilder(CHANNEL_2, "첫번째 채널")
            .setSmallIcon(android.R.drawable.ic_menu_search)
            .setLargeIcon(bitmap)
            .setNumber(100)         // 알림 메시지 안에 보여줄 숫자설정 ex> 미확인 메시지 수
            .setContentTitle("Content Title 4")
            .setContentText("Content Text 4")

        val notification = builder1.build()
        manager.notify(NOTI_ID_4, notification)
    }

    /**
     * 안드로이드 8.0이상과 미만 버전에 대응하기 위해 채널을 설정하는 메서드
     * */
    private fun getNotificationBuilder(id: String, name: String): NotificationCompat.Builder {
        var builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 채널 객체 생성
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            // 메시지 출력시 단말기 LED 설정
            channel.enableLights(true)
            // LED 색상 설정
            channel.lightColor = Color.RED
            // 진동 사용여부
            channel.enableVibration(true)

            // 알림 메시지를 관리하는 객체에 채널을 등록한다.
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, id)
        } else {
            builder = NotificationCompat.Builder(this)
        }

        return builder
    }

    companion object {
        private const val CHANNEL_1 = "channel1"
        private const val CHANNEL_2 = "channel2"
        private const val NOTI_ID_1 = 10
        private const val NOTI_ID_2 = 20
        private const val NOTI_ID_3 = 30
        private const val NOTI_ID_4 = 40
    }
}