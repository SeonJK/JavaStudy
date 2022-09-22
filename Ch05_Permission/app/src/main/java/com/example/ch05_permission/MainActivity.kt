package com.example.ch05_permission

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.ch05_permission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val permissionList = arrayOf(
        Manifest.permission.INTERNET,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.WRITE_CONTACTS,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = ""

        for (permission in permissionList) {
            val chk = ContextCompat.checkSelfPermission(this, permission)

            if (chk == PackageManager.PERMISSION_GRANTED) {
                binding.textView.append("$permission : 허용\n")
            } else if (chk == PackageManager.PERMISSION_DENIED) {
                binding.textView.append("$permission : 거부\n")
            }
        }

        binding.button.setOnClickListener {
            // 거부되어 있는 권한들을 사용자에게 확인받는다.
            requestPermissionLauncher.launch(permissionList)
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions: Map<String, Boolean> ->
            for (permission in permissions) {
                if (!permission.value == false) {
                    binding.textView.append("${permission.key} : 허용")
                } else {
                    binding.textView.append("${permission.key} : 거부")
                }
            }
        }
}