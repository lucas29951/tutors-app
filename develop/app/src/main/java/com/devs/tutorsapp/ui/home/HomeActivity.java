package com.devs.tutorsapp.ui.home;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.ui.clase.ClaseFragment;
import com.devs.tutorsapp.ui.perfil.PerfilFragment;
import com.devs.tutorsapp.ui.tutor.TutorFragment;
import com.devs.tutorsapp.utils.SharedPrefManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);

        loadFragment(new HomeFragment());

        bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int id = item.getItemId();

            if (id == R.id.nav_inicio) {
                selectedFragment = new HomeFragment();
            } else if (id == R.id.nav_tutores) {
                selectedFragment = new TutorFragment();
            } else if (id == R.id.nav_clases) {
                selectedFragment = new ClaseFragment();
            } else if (id == R.id.nav_perfil) {
                selectedFragment = new PerfilFragment();
            }

            if (selectedFragment != null) {
                loadFragment(selectedFragment);
            }

            return true;
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}