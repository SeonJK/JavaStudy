package com.example.ch19_listdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ch19_listdialog.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class MainJavaActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    String[] data = {"item1", "item2", "item3", "item4", "item5", "item6"};
    String[] data2 = {"토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국"};
    int[] data3 = {
            R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4,
            R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("List Dialog");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setNegativeButton("취소", null);
            builder.setItems(data, (dialogInterface, i) -> {
                binding.textView.setText("리스트 다이얼로그 아이템 : " + data[i]);
            });
            builder.show();
        });

        binding.button2.setOnClickListener(view -> {
            ArrayList<HashMap<String, Object>> list = new ArrayList<>();

            for (int idx=0; idx<data2.length; idx++) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("data2", data2[idx]);
                map.put("data3", data3[idx]);

                list.add(map);
            }

            String[] keys = {"data2", "data3"};
            int[] ids = {R.id.custom_text, R.id.custom_image};

            SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.custom_list, keys, ids);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("커스텀 다이얼로그");
            builder.setAdapter(adapter, (dialogInterface, i) -> {
                binding.textView.setText("커스텀 다이얼로그: " + data2[i]);
            });
            builder.setNegativeButton("취소", null);
            builder.show();
        });
    }
}
