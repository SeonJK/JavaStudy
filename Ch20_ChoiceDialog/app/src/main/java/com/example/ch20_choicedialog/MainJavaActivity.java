package com.example.ch20_choicedialog;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ch20_choicedialog.databinding.ActivityMainBinding;

public class MainJavaActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    String[] data1 = {"item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item8"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog builder = new AlertDialog.Builder(MainJavaActivity.this)
                        .setTitle("Single Choice list")
                        .setSingleChoiceItems(data1, 1, (dialogInterface, i) -> {
                            Toast.makeText(MainJavaActivity.this, data1[i], Toast.LENGTH_SHORT).show();
                        })
                        .setPositiveButton("확인", ((dialogInterface, i) -> {
                            AlertDialog alert = (AlertDialog) dialogInterface;
                            int idx = alert.getListView().getCheckedItemPosition();

                            binding.textView.setText("선택된 항목: " + data1[idx]);
                        }))
                        .setNegativeButton("취소", null)
                        .show();
            }
        });

        binding.button2.setOnClickListener(view -> {
            boolean[] boolArray = {true, false, false, true, false, false, false, false};

            AlertDialog builder = new AlertDialog.Builder(MainJavaActivity.this)
                    .setMultiChoiceItems(data1, boolArray, ((dialogInterface, i, checked) -> {
                        if (checked) {
                            Toast.makeText(MainJavaActivity.this, data1[i] + "가 체크되었습니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainJavaActivity.this, data1[i] + "가 체크해제 되었습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }))
                    .setNegativeButton("취소", null)
                    .setPositiveButton("확인", ((dialogInterface, i) -> {
                        AlertDialog alert = (AlertDialog) dialogInterface;
                        SparseBooleanArray positions = alert.getListView().getCheckedItemPositions();

                        for (int idx = 0; i<positions.size(); idx++) {
                            int index = positions.keyAt(idx);

                            if (positions.get(index)) {
                                binding.textView.append(data1[index] + ", ");
                            }
                        }
                    }))
                    .show();
        });
    }
}
