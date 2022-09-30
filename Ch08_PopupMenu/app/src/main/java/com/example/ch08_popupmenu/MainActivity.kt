package com.example.ch08_popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import com.example.ch08_popupmenu.databinding.ActivityMainBinding

/* Popup Menu는 개발자가 원할 때 원하는 곳에 띄울 수 있는 메뉴 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            // Popup Menu 객체를 생성한다.
            val pop = PopupMenu(this, binding.textView)

            // 메뉴를 구성한다.
            menuInflater.inflate(R.menu.menu, pop.menu)

            /**
             * 메뉴의 항목을 눌렀을 때 반응하는 리스너
             * */
            pop.setOnMenuItemClickListener {
                when(it.itemId) {
                    R.id.item1 -> binding.textView.text = "메뉴 1을 눌렀습니다."
                    R.id.item2 -> binding.textView.text = "메뉴 2를 눌렀습니다."
                    R.id.item3 -> binding.textView.text = "메뉴 3을 눌렀습니다."
                }
                true
            }

            pop.show()
        }
    }


}