package com.devs.tutorsapp.ui.home;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

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

        setContentView(R.layout.activity_home);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        NavController navController = navHostFragment.getNavController();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);

        NavigationUI.setupWithNavController(bottomNavigation, navController);
    }
}