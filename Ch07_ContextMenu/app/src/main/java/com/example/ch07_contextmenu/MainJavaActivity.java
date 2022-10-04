package com.example.ch07_contextmenu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ch07_contextmenu.databinding.ActivityMainBinding;

/* ContextMenu: View에 설정할 수 있는 메뉴. View를 길게 누르면 메뉴가 나온다. */

public class MainJavaActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private final String[] data1 = {"항목1", "항목2", "항목3", "항목4", "항목5"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data1);
        binding.list.setAdapter(adapter);

        binding.list.setOnItemClickListener( (adapterView, view, idx, l) -> {
            binding.textView.setText(String.format("리스트뷰의 항목 클릭 : %s", data1[idx]));
        });

        /**
         * ContextMenu를 View에 등록한다.
         * */
        registerForContextMenu(binding.textView);
        registerForContextMenu(binding.list);
    }

    /**
     * @param menu 컨텍스트메뉴
     * @param v 컨텍스트메뉴를 설정할 뷰
     * @param menuInfo 어댑터 컨텍스트 인포를 볼 수 있는데, 리스트뷰의 어떤 아이템이 롱클릭 됐는지 알 수 있다.
     *
     * View를 길게 누르면 호출되는 메서드. 이곳에서 메뉴를 구성한다.
     * */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // 길게 누른 id의 뷰로 분기
        int id = (v!=null) ? v.getId() : null;
        switch (id) {
            case R.id.textView:
                if (menu != null) {
                    menu.setHeaderTitle("텍스트뷰의 메뉴");
                }
                getMenuInflater().inflate(R.menu.menu1, menu);
                break;
            case R.id.list:
                // 사용자가 길게 누른 항목의 인덱스 번호를 파악하기 위해
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

                if (menu != null) {
                    menu.setHeaderTitle("리스트뷰의 메뉴" + info.position+1);
                }
                getMenuInflater().inflate(R.menu.menu2, menu);
                // getMenuInflater().inflate()를 통해 누르는 아이템마다 메뉴를 다르게 설정할 수 있다.
                break;
        }
    }

    /**
     * 메뉴 항목을 눌렀을 때 나오는 메서드
     * */
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        // 리스트 항목의 인덱스 번호를 받을 변수
        int position = 0;

        switch (item.getItemId()) {
            case R.id.list_item1:
            case R.id.list_item2:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                position = info.position;
                break;
        }

        // 메뉴의 id값으로 분기
        switch (item.getItemId()) {
            case R.id.menuOne:
                binding.textView.setText("첫번째 항목을 눌렀습니다.");
                break;
            case R.id.menuTwo:
                binding.textView.setText("두번째 항목을 눌렀습니다.");
                break;
            case R.id.list_item1:
                binding.textView.setText(String.format("리스트 뷰의 아이템 1을 눌렀습니다. : ", position));
                break;
            case R.id.list_item2:
                binding.textView.setText(String.format("리스트 뷰의 아이템 2을 눌렀습니다. : ", position));
                break;
        }

        return super.onContextItemSelected(item);
    }
}
