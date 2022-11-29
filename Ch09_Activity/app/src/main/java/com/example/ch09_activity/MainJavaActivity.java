package com.example.ch09_activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ch09_activity.databinding.ActivityMainBinding;

public class MainJavaActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    private ActivityMainBinding binding;

    // 화면이 생성될 때 호출
    // 화면 전환이 발생할 때 호출
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d(TAG, "onCreate() called");
    }

    // onCreate()가 호출되고 자동으로 호출
    // 액티비티가 정지 상태가 되었다가 활동 상태로 돌아갈 때 호출
    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart() called");
    }

    // onStart()가 호출되고 자동으로 호출
    // 액티비티가 일시정지 상태가 되었다가 다시 돌아돌 때 호출
    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume() called");
    }

    // 액티비티가 정지 상태가 되었다가 활동 상태로 돌아갈 때 onStart() 전에 호출
    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart() called");
    }

    // 액티비티가 일시정지 상태가 될 때 호출
    // 화면 상에서 완전히 사라지거나 현재 화면 위에 작은 팝업창이 나타날 때 호출
    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause() called");
    }

    // 액티비티가 화면 상에서 사라질 때 호출
    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop() called");
    }

    // 현재 액티비티의 수행이 완전히 종료되어 메모리 상에서 제거될 때 호출
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy() called");
    }
}