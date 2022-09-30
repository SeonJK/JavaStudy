package com.example.ch12_intent

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ch12_intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java). apply {
                putExtra("data1", 100)
                putExtra("data2", 11.11)
                putExtra("data3", true)
                putExtra("data4", "문자열")
            }
//            startActivity(intent)

            launcher.launch(intent)
        }
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val value = it.data?.getIntExtra("data1", 0)

        binding.textView.text = value.toString()
    }
}