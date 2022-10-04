package com.example.ch06_optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.ch06_optionmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /**
     * Activity 객체가 만들어질  자동호출되는 메서드
     * 메뉴가 고정적이라면 xml에서, 유동적이라면 코드에서 작성하는 것이 좋세
     * @return true면 메뉴가 나타남
     * */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // XML로 메뉴 구성하는 방법
//        menuInflater.inflate(R.menu.main_menu, menu)

        // 코드로 메뉴 구성하는 방법
        menu?.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드 메뉴 1")
//        menu?.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "코드 메뉴 2")
        val sub = menu?.addSubMenu("코드 메뉴 2")
        sub?.add(Menu.NONE, Menu.FIRST+10, Menu.NONE, "코드 메뉴 2-1")
        sub?.add(Menu.NONE, Menu.FIRST+11, Menu.NONE, "코드 메뉴 2-2")

        menu?.add(Menu.NONE, Menu.FIRST+2, Menu.NONE, "코드 메뉴 3")
        return true
    }

    /**
     * 사용자가 메뉴를 선택했을 때 자동으로 호출되는 메서드
     * */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // XML로 구성하는 방법
//        when(item.itemId) {
//            R.id.menuOne -> binding.textView.text = "첫번째 메뉴를 눌렀습니다."
////            R.id.menuTwo -> binding.textView.text = "두번째 메뉴를 눌렀습니다."
//            R.id.menuTwoByOne -> binding.textView.text = "두번째의 첫번째 메뉴를 눌렀습니다."
//            R.id.menuTwoByTwo -> binding.textView.text = "두번째의 두번째 메뉴를 눌렀습니다."
//            R.id.menuThree -> binding.textView.text = "세번째 메뉴를 눌렀습니다."
//        }

        // 코드로 구성하는 방법
        when(item.itemId) {
            Menu.FIRST -> binding.textView.text = "코드 메뉴 첫번째를 눌렀습니다."
//            Menu.FIRST+1 -> binding.textView.text = "코드 메뉴 두번째를 눌렀습니다."
            Menu.FIRST+10 -> binding.textView.text = "코드 메뉴 두번째의 1를 눌렀습니다."
            Menu.FIRST+11 -> binding.textView.text = "코드 메뉴 두번째의 2를 눌렀습니다."

            Menu.FIRST+2 -> binding.textView.text = "코드 메뉴 세번째를 눌렀습니다."
        }

        return super.onOptionsItemSelected(item)
    }
}