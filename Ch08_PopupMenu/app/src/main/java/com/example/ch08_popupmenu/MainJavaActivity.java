package com.example.ch08_popupmenu;

import android.os.Bundle;
import android.widget.PopupMenu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ch08_popupmenu.databinding.ActivityMainBinding;

public class MainJavaActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            // Popup Menu 객체를 생성한다.
            PopupMenu pop = new PopupMenu(this, binding.textView);

            // 메뉴를 구성한다.
            getMenuInflater().inflate(R.menu.menu, pop.getMenu());

            /**
             * 메뉴의 항목을 눌렀을 때 반응하는 리스너
             * */
            pop.setOnMenuItemClickListener(menuItem -> {
                switch (menuItem.getItemId()) {
                    case R.id.item1:
                        binding.textView.setText("메뉴 1을 눌렀습니다.");
                        break;
                    case R.id.item2:
                        binding.textView.setText("메뉴 2를 눌렀습니다.");
                        break;
                    case R.id.item3:
                        binding.textView.setText("메뉴 3을 눌렀습니다.");
                        break;
                }
                return true;
            });

            pop.show();
        });
    }
}
