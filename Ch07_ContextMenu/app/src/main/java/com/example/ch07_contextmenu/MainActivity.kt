package com.example.ch07_contextmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.ch07_contextmenu.databinding.ActivityMainBinding

/* ContextMenu: View에 설정할 수 있는 메뉴. View를 길게 누르면 메뉴가 나온다. */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val data1 = arrayOf(
        "항목1", "항목2", "항목3", "항목4", "항목5"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        binding.list.adapter = adapter

        binding.list.setOnItemClickListener { adapterView, view, idx, l ->
            binding.textView.text = "리스트뷰의 항목 클릭 : ${data1[idx]}"
        }

        /**
         * ContextMenu를 View에 등록한다.
         * */
        registerForContextMenu(binding.textView)
        registerForContextMenu(binding.list)
    }


    /**
     * @param menu 컨텍스트메뉴
     * @param v 컨텍스트메뉴를 설정할 뷰
     * @param menuInfo 어댑터 컨텍스트 인포를 볼 수 있는데, 리스트뷰의 어떤 아이템이 롱클릭 됐는지 알 수 있다.
     *
     * View를 길게 누르면 호출되는 메서드. 이곳에서 메뉴를 구성한다.
     * */
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        // 길게 누른 id의 뷰로 분기
        when(v?.id) {
            R.id.textView -> {
                menu?.setHeaderTitle("텍스트뷰의 메뉴")
                menuInflater.inflate(R.menu.menu1, menu)
            }
            R.id.list -> {
                // 사용자가 길게 누른 항목의 인덱스 번호를 파악하기 위해
                val info = menuInfo as AdapterView.AdapterContextMenuInfo

                menu?.setHeaderTitle("리스트뷰의 메뉴: ${info.position+1}")
                menuInflater.inflate(R.menu.menu2, menu)
                // menuInflater.inflate()를 통해 누르는 아이템마다 메뉴를 다르게 설정할 수 있다.
            }
        }
    }

    /**
     * 메뉴 항목을 눌렀을 때 나오는 메서드
     * */
    override fun onContextItemSelected(item: MenuItem): Boolean {

        // 리스트 항목의 인덱스 번호를 받을 변수
        var position = 0

        when(item.itemId) {
            R.id.list_item1, R.id.list_item2 -> {
                val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                position = info.position
            }
        }

        // 메뉴의 id값으로 분기
        when(item.itemId) {
            R.id.menuOne -> binding.textView.text = "첫번째 항목을 눌렀습니다."
            R.id.menuTwo -> binding.textView.text = "두번째 항목을 눌렀습니다."
            R.id.list_item1 -> binding.textView.text = "리스트 뷰의 아이템 1을 눌렀습니다. : $position"
            R.id.list_item2 -> binding.textView.text = "리스트 뷰의 아이템 2을 눌렀습니다. : $position"
        }

        return super.onContextItemSelected(item)
    }
}