package com.devs.tutorsapp.ui.home;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.utils.SharedPrefManager;

public class HomeActivity extends AppCompatActivity {

    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPrefManager = SharedPrefManager.getInstance(this);

        if (!sharedPrefManager.isLoggedIn()) {
            finish();
            return;
        }

        setContentView(R.layout.activity_home);
    }
}