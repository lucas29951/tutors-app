package com.devs.tutorsapp.ui.clase;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.ui.viewmodel.ClaseDetalleViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClaseDetalleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClaseDetalleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView tvTutorName, tvTutorStats, tvTutorDesc, tvTutorPrice, tvMateria, tvFecha, tvHora, tvEstado;
    private Button btnResena;
    private ClaseDetalleViewModel viewModel;
    private int claseId;

    public ClaseDetalleFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClaseDetalleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClaseDetalleFragment newInstance(String param1, String param2) {
        ClaseDetalleFragment fragment = new ClaseDetalleFragment();
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
        return inflater.inflate(R.layout.fragment_clase_detalle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTutorName = view.findViewById(R.id.tvTutorName);
        tvTutorStats = view.findViewById(R.id.tvTutorStats);
        tvTutorDesc = view.findViewById(R.id.tvTutorDesc);
        tvTutorPrice = view.findViewById(R.id.tvTutorPrice);
        tvMateria = view.findViewById(R.id.tvMateria);
        tvFecha = view.findViewById(R.id.tvFecha);
        tvHora = view.findViewById(R.id.tvHora);
        tvEstado = view.findViewById(R.id.tvEstado);
        btnResena = view.findViewById(R.id.btnResena);

        viewModel = new ViewModelProvider(this).get(ClaseDetalleViewModel.class);

        Bundle args = getArguments();
        if (args != null) {
            claseId = args.getInt("clase_id", -1);
        }

        loadData();

        btnResena.setOnClickListener(v -> {
            //navegar a la pantalla
        });
    }

    private void loadData() {
        viewModel.getClaseById(claseId).observe(getViewLifecycleOwner(), clase -> {
            if (clase == null) return;

            tvFecha.setText(clase.getFecha());
            tvHora.setText(clase.getHora_inicio());
            tvEstado.setText(clase.getEstado());

            viewModel.getTutorById(clase.getTutor_id()).observe(getViewLifecycleOwner(), tutor -> {
                if (tutor != null) {
                    tvTutorName.setText(tutor.getNombre() + " " + tutor.getApellido());
                    tvTutorStats.setText("★ " + tutor.getRating());
                    tvTutorDesc.setText(tutor.getDescripcion());
                    tvTutorPrice.setText("$ " + tutor.getPrecio() + "/h");
                }
            });

            viewModel.getMateriaById(clase.getMateria_id()).observe(getViewLifecycleOwner(), materia -> {
                if (materia != null) {
                    tvMateria.setText(materia.getNombre());
                }
            });
        });
    }
}