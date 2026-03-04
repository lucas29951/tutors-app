package com.devs.tutorsapp.ui.resena;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.data.local.entity.ResenaEntity;
import com.devs.tutorsapp.ui.viewmodel.ClaseDetalleViewModel;
import com.devs.tutorsapp.ui.viewmodel.ResenaViewModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResenaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResenaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RatingBar ratingBar;
    private EditText etComentario;
    private ChipGroup chipGroup;
    private Button btnEnviar;
    private ResenaViewModel viewModel;
    private ClaseDetalleViewModel claseDetalleViewModel;
    private int tutorId, alumnoId, claseId;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ResenaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResenaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResenaFragment newInstance(String param1, String param2) {
        ResenaFragment fragment = new ResenaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resena, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ratingBar = view.findViewById(R.id.ratingBar);
        etComentario = view.findViewById(R.id.etComentario);
        chipGroup = view.findViewById(R.id.chipGroup);
        btnEnviar = view.findViewById(R.id.btnEnviar);

        viewModel = new ViewModelProvider(this).get(ResenaViewModel.class);
        claseDetalleViewModel = new ViewModelProvider(this).get(ClaseDetalleViewModel.class);

        Bundle args = getArguments();
        if (args != null) {
            tutorId = args.getInt("tutor_id");
            alumnoId = args.getInt("alumno_id");
            claseId = args.getInt("clase_id");
        }

        btnEnviar.setOnClickListener(v -> {
            guardarResena();
        });

    }

    private void guardarResena() {
        double rating = ratingBar.getRating();
        String comentario = etComentario.getText().toString();

        StringBuilder aspectos = new StringBuilder();
        for (int i = 0; i < chipGroup.getChildCount(); i++) {
            Chip chip = (Chip) chipGroup.getChildAt(i);
            if (chip.isChecked()) {
                aspectos.append(chip.getText()).append(", ");
            }
        }
        aspectos.append(comentario);

        String fecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                .format(new Date());

        ResenaEntity newResena = new ResenaEntity(alumnoId, tutorId, rating, aspectos.toString(), fecha);

        viewModel.guardarResena(newResena);
        claseDetalleViewModel.deleteClase(claseId);

        Toast.makeText(getContext(), "Reseña enviada", Toast.LENGTH_SHORT).show();

        NavController navController = Navigation.findNavController(requireActivity(), R.id.fragment_container);

        NavOptions navOptions = new NavOptions.Builder()
                .setPopUpTo(R.id.nav_clases, true)
                        .build();

        navController.navigate(R.id.nav_inicio, null, navOptions);
    }
}