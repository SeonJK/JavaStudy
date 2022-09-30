package com.example.ch12_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch12_intent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getDoubleExtra("data2", 0.0)
        val data3 = intent.getBooleanExtra("data3", false)
        val data4 = intent.getStringExtra("data4")

        binding.textView.text = "$data1 "
        binding.textView.append("$data2 ")
        binding.textView.append("$data3 ")
        binding.textView.append("$data4 ")

        binding.button.setOnClickListener {
            finish()
        }
    }
}