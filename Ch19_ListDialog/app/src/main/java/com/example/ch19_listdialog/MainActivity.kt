package com.example.ch19_listdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.example.ch19_listdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val data = arrayOf("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8")
    val data2 = arrayOf("토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국")
    val data3 = intArrayOf(
        R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4,
        R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
                .setTitle("List Dialog")
                .setIcon(R.mipmap.ic_launcher)
                .setNegativeButton("취소", null)
                .setItems(data) { dialogInterface, i ->
                    binding.textView.text = "리스트 다이얼로그 아이템 : ${data[i]}"
                }
                .show()
        }

        binding.button2.setOnClickListener {
            val list1 = ArrayList<HashMap<String, Any?>>()

            for (idx in data2.indices) {
                val map = HashMap<String, Any?>().apply {
                    this["data2"] = data2[idx]
                    this["data3"] = data3[idx]
                }
                list1.add(map)
            }

            val keys = arrayOf("data2", "data3")
            val ids = intArrayOf(R.id.custom_text, R.id.custom_image)

            val adapter = SimpleAdapter(this, list1, R.layout.custom_list, keys, ids)

            val builder = AlertDialog.Builder(this)
                .setTitle("커스텀 다이얼로그")
                .setAdapter(adapter) { dialogInterface, i ->
                    binding.textView.text = "커스텀 다이얼로그: ${data2[i]}"
                }
                .setNegativeButton("취소", null)
                .show()
        }
    }
}