package com.example.ch20_choicedialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.ch20_choicedialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val data1 = arrayOf("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
                .setTitle("Single Choice list")
                .setSingleChoiceItems(data1, 1) { dialogInterface, i ->
                    val t1 = Toast.makeText(this, data1[i], Toast.LENGTH_SHORT)
                    t1.show()
                }
                .setPositiveButton("확인") {dialogInterface, i ->
                    val alert = dialogInterface as AlertDialog
                    val idx = alert.listView.checkedItemPosition

                    binding.textView.text = "선택된 항목: ${data1[idx]}"
                }
                .setNegativeButton("취소", null)
                .show()
        }

        binding.button2.setOnClickListener {
            val boolArray = booleanArrayOf(true, false, false, true, false, false, false, false)

            val builder = AlertDialog.Builder(this)
                .setMultiChoiceItems(data1, boolArray) { dialogInterface, i, checked ->
                    if (checked) {
                        val t1 = Toast.makeText(this, "${data1[i]}가 체크되었습니다.", Toast.LENGTH_SHORT)
                        t1.show()
                    } else {
                        val t2 = Toast.makeText(this, "${data1[i]}가 체크해제 되었습니다.", Toast.LENGTH_SHORT)
                        t2.show()
                    }
                }
                .setNegativeButton("취소", null)
                .setPositiveButton("확인") { dialogInterface, i ->
                    val alert = dialogInterface as AlertDialog
                    val positions = alert.listView.checkedItemPositions

                    for (i in 0 until positions.size()) {
                        // 체크상태가 변경된 항목의 인덱스를 추출한다.
                        var index = positions.keyAt(i)

                        if (positions.get(index)) {
                            binding.textView.append("${data1[index]}, ")
                        }
                    }
                }
                .show()
        }
    }
}