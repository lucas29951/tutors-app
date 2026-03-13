package com.devs.tutorsapp.ui.tutor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.devs.tutorsapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class FiltersBottomSheet extends BottomSheetDialogFragment {

    private SeekBar seekPrice;
    private RatingBar ratingBar;
    private CheckBox checkAvailable;
    private Button btnApply;

    public interface FilterListener {
        void onFiltersApplied(int price, float rating, boolean available);
    }

    private FilterListener listener;

    public FiltersBottomSheet(FilterListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheet_filters, container, false);

        seekPrice = view.findViewById(R.id.seekPrice);
        ratingBar = view.findViewById(R.id.ratingFilter);
        checkAvailable = view.findViewById(R.id.checkAvailable);
        btnApply = view.findViewById(R.id.btnApplyFilters);

        btnApply.setOnClickListener(v -> {
            int price = seekPrice.getProgress();
            float rating = ratingBar.getRating();
            boolean available = checkAvailable.isChecked();

            listener.onFiltersApplied(price, rating, available);

            dismiss();
        });

        return  view;
    }
}
