package com.devs.tutorsapp.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;

import com.devs.tutorsapp.MainActivity;
import com.devs.tutorsapp.R;
import com.devs.tutorsapp.ui.home.HomeActivity;
import com.devs.tutorsapp.ui.viewmodel.AuthViewModel;
import com.devs.tutorsapp.utils.SharedPrefManager;

public class LoginActivity extends AppCompatActivity {

    private AuthViewModel authViewModel;
    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvRegistro;
    private CheckBox checkRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.activity_login);

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegistro = findViewById(R.id.tvSignUp);
        checkRemember = findViewById(R.id.cbRememberMe);

        btnLogin.setOnClickListener(v -> login());

        tvRegistro.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
            startActivity(intent);
        });

        authViewModel.getErrorMessage().observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        });

        authViewModel.getAlumno().observe(this, alumno -> {
            Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show();

            if (checkRemember.isChecked()) {
                SharedPrefManager.getInstance(this).saveLogin(alumno.getAlumno_id(), alumno.getNombre(), alumno.getEmail());
            }

            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("idAlumno", alumno.getAlumno_id());
            intent.putExtra("nombreAlumno", alumno.getNombre() + " " + alumno.getApellido());
            intent.putExtra("emailAlumno", alumno.getEmail());
            startActivity(intent);
            finish();
            return;
        });
    }

    private void login() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        authViewModel.login(email, password);
    }
}