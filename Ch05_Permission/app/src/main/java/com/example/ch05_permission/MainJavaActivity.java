package com.example.ch05_permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.ch05_permission.databinding.ActivityMainBinding;

import java.util.Iterator;
import java.util.Map;

public class MainJavaActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    String[] permissionList = new String[]{
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textView.setText("");

        for (String permission : permissionList) {
            int chk = ContextCompat.checkSelfPermission(this, permission);

            if (chk == PackageManager.PERMISSION_GRANTED) {
                binding.textView.append(permission + "허용\n");
            } else if (chk == PackageManager.PERMISSION_DENIED) {
                binding.textView.append(permission + "거부\n");
            }
        }

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 거부되어 있는 권한들을 사용자에게 확인받는다.

            }
        });
    }

    private ActivityResultLauncher requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() {
                @Override
                public void onActivityResult(Map<String, Boolean> result) {
                    Iterator iter = result.entrySet().iterator();

                    while(iter.hasNext()) {
                        Map.Entry permission = (Map.Entry) iter.next();
                        if ((Boolean) permission.getValue() != false) {
                            binding.textView.append(permission.getKey() + " : 허용");
                        } else {
                            binding.textView.append(permission.getKey() + " : 거부");
                        }
                    }
                }
            });
}
