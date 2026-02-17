package com.devs.tutorsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.devs.tutorsapp.ui.auth.LoginActivity;
import com.devs.tutorsapp.ui.auth.RegistroActivity;
import com.devs.tutorsapp.ui.home.HomeActivity;
import com.devs.tutorsapp.utils.SharedPrefManager;

public class MainActivity extends AppCompatActivity {

    private Button btnSignIn, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPrefManager prefs = SharedPrefManager.getInstance(this);

        if (prefs.isFirstTime()) {
            prefs.setFirstTimeFalse();
            setContentView(R.layout.activity_main);
            initViews();
            return;
        }

        if (prefs.isLoggedIn()) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("idAlumno", prefs.getAlumnoId());
            intent.putExtra("nombreAlumno", prefs.getAlumnoNombre());
            intent.putExtra("emailAlumno", prefs.getAlumnoEmail());
            startActivity(intent);
            finish();
            return;
        }

        startActivity(new Intent(this, LoginActivity.class));
        finish();
        return;
    }

    private void initViews() {
        btnSignIn = findViewById(R.id.btnSignIn);
        btnRegister = findViewById(R.id.btnRegister);

        btnSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        });

        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
            startActivity(intent);
            finish();
            return;
        });
    }
}