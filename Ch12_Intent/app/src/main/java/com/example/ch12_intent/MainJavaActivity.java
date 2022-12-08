package com.example.ch12_intent;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ch12_intent.databinding.ActivityMainBinding;

public class MainJavaActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondJavaActivity.class);
            intent.putExtra("data1", 100);
            intent.putExtra("data2", 11.11);
            intent.putExtra("data3", true);
            intent.putExtra("data4", "문자열");

//            startActivity(intent);

            launcher.launch(intent);
        });
    }

    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    int value = result.getData().getIntExtra("data1", 0);

                    binding.textView.setText(value);
                }
            }
    );
}
