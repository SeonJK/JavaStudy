package com.example.ch06_optionmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ch06_optionmenu.databinding.ActivityMainBinding;

public class MainJavaActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    /**
     * Activity 객체가 만들어질  자동호출되는 메서드
     * 메뉴가 고정적이라면 xml에서, 유동적이라면 코드에서 작성하는 것이 좋세
     * @return true면 메뉴가 나타남
     * */
    @Override
    public boolean onCreateOptionsMenu(@Nullable Menu menu) {
        // XML로 구성하는 방법
//        getMenuInflater().inflate(R.menu.main_menu, menu);

        // 코드로 메뉴 구성하는 방법
        if (menu == null) {
            return false;
        }

        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드 메뉴 1");
//        menu.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "코드 메뉴 2");

        SubMenu sub = menu.addSubMenu("코드 메뉴 2");
        if (sub == null) {
            return false;
        }
        sub.add(Menu.NONE, Menu.FIRST+10, Menu.NONE, "코드 메뉴 2-1");
        sub.add(Menu.NONE, Menu.FIRST+11, Menu.NONE, "코드 메뉴 2-2");

        menu.add(Menu.NONE, Menu.FIRST+2, Menu.NONE, "코드 메뉴 3");
        return true;
    }

    /**
     * 사용자가 메뉴를 선택했을 때 자동으로 호출되는 메서드
     * */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // XML로 구성하는 방법
//        switch (item.getItemId()) {
//            case R.id.menuOne:
//                binding.textView.setText("첫번째 메뉴를 눌렀습니다.");
//                break;
////            case R.id.menuTwo:
////                binding.textView.setText("두번째 메뉴를 눌렀습니다.");
////                break;
//            case R.id.menuTwoByOne:
//                binding.textView.setText("두번째의 첫번째 메뉴를 눌렀습니다.");
//                break;
//            case R.id.menuTwoByTwo:
//                binding.textView.setText("두번째의 두번째 메뉴를 눌렀습니다.");
//                break;
//            case R.id.menuThree:
//                binding.textView.setText("세번째 메뉴를 눌렀습니다.");
//                break;
//        }

        // 코드로 구성하는 방법
        switch (item.getItemId()) {
            case Menu.FIRST:
                binding.textView.setText("코드 메뉴 첫번째를 눌렀습니다.");
                break;
//            case Menu.FIRST+1:
//                binding.textView.setText("코드 메뉴 두번째를 눌렀습니다.");
//                break;
            case Menu.FIRST+10:
                binding.textView.setText("코드 메뉴 두번째의 1를 눌렀습니다.");
                break;
            case Menu.FIRST+11:
                binding.textView.setText("코드 메뉴 두번째의 2를 눌렀습니다.");
                break;

            case Menu.FIRST+2:
                binding.textView.setText("코드 메뉴 세번째를 눌렀습니다.");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
