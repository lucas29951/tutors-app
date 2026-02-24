package com.devs.tutorsapp.ui.clase.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.devs.tutorsapp.ui.clase.ClasesListFragment;

public class ClasesPagerAdapter extends FragmentStateAdapter {

    public ClasesPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return ClasesListFragment.newInstance("Pending");

            case 1:
                return ClasesListFragment.newInstance("Confirmed");

            case 2:
                return ClasesListFragment.newInstance("Completed");

            default:
                return new ClasesListFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
