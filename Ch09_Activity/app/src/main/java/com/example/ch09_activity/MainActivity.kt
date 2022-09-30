package com.example.ch09_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ch09_activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // 화면이 생성될 때 호출
    // 화면 전환이 발생할 때 호출
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("test1", "onCreate() called")
    }

    // onCreate()가 호출되고 자동으로 호출
    // 액티비티가 정지 상태가 되었다가 활동 상태로 돌아갈 때 호출
    override fun onStart() {
        super.onStart()

        Log.d("test1", "onStart() called")
    }

    // onStart()가 호출되고 자동으로 호출
    // 액티비티가 일시정지 상태가 되었다가 다시 돌아올 때 호출
    override fun onResume() {
        super.onResume()

        Log.d("test1", "onResume() called")
    }

    // 액티비티가 정지 상태가 되었다가 활동 상태로 돌아갈 때 onStart() 전에 호출
    override fun onRestart() {
        super.onRestart()

        Log.d("test1", "onRestart() called")
    }

    // 액티비티가 일시정지 상태가 될 때 호출
    // 화면 상에서 완전히 사라지거나 현재 화면 위에 작은 팝업창이 나타날 때 호출
    override fun onPause() {
        super.onPause()

        Log.d("test1", "onPause() called")
    }

    // 액티비티가 화면 상에서 사라질 때 호출
    override fun onStop() {
        super.onStop()

        Log.d("test1", "onStop() called")
    }

    // 현재 액티비티의 수행이 완전히 종료되어 메모리 상에서 제거될 때 호출
    override fun onDestroy() {
        super.onDestroy()

        Log.d("test1", "onDestroy() called")
    }
}