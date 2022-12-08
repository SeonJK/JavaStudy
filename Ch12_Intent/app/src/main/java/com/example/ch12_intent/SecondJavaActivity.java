package com.example.ch12_intent;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ch12_intent.databinding.ActivitySecondBinding;

public class SecondJavaActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int data1 = getIntent().getIntExtra("data1", 0);
        double data2 = getIntent().getDoubleExtra("data2", 0.0);
        boolean data3 = getIntent().getBooleanExtra("data3", false);
        String data4 = getIntent().getStringExtra("data4");

        binding.textView.setText(data1);
        binding.textView.append(" " + data2);
        binding.textView.append(" " + data3);
        binding.textView.append(" " + data4);

        binding.button.setOnClickListener(view -> {
            finish();
        });
    }
}
