package com.devs.tutorsapp.ui.clase;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.data.local.entity.ClaseEntity;
import com.devs.tutorsapp.data.local.entity.DisponibilidadEntity;
import com.devs.tutorsapp.data.local.entity.MateriaEntity;
import com.devs.tutorsapp.data.local.entity.TutorEntity;
import com.devs.tutorsapp.ui.viewmodel.ReservaClaseViewModel;
import com.devs.tutorsapp.ui.viewmodel.SessionViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReservaClaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReservaClaseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ReservaClaseViewModel viewModel;
    private SessionViewModel sessionViewModel;
    private LinearLayout containerSubjects, containerMonday, containerTuesday, containerWednesday, containerThursday, containerFriday;
    private Button btnRequest;
    private ImageView btnBack;
    private TextView txtNameTutor, txtStatsTutor, txtDescTutor;
    private int tutorId = 1;
    private int alumnoId = 1;
    private int selectedSubject = -1;
    private String selectedHorario = null;
    private String selectedDia = null;
    private List<DisponibilidadEntity> disponibilidades;

    public ReservaClaseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReservaClaseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReservaClaseFragment newInstance(String param1, String param2) {
        ReservaClaseFragment fragment = new ReservaClaseFragment();
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

        return inflater.inflate(R.layout.fragment_reserva_clase, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            tutorId = getArguments().getInt("tutorId");
        }

        sessionViewModel = new ViewModelProvider(requireActivity()).get(SessionViewModel.class);
        sessionViewModel.getAlumnoId().observe(getViewLifecycleOwner(), id -> {
            alumnoId = id;

            viewModel = new ViewModelProvider(this).get(ReservaClaseViewModel.class);

            initViews(view);

            viewModel.getTutorById(tutorId).observe(getViewLifecycleOwner(), tutor -> {
                if (tutor != null) {
                    bindTutor(tutor);
                }
            });

            viewModel.getMateriasByTutor(tutorId).observe(getViewLifecycleOwner(), materias -> {
               if (materias != null) {
                   loadSubjects(materias);
               }
            });

            viewModel.getDisponibilidadesByTutor(tutorId).observe(getViewLifecycleOwner(), dispo -> {
                if (dispo != null) {
                    loadDisponibilidad(dispo);
                }
            });

            setupButton();
        });
    }

    private void bindTutor(TutorEntity tutor) {
        txtNameTutor.setText(tutor.getNombre() + " " + tutor.getApellido());
        txtStatsTutor.setText("$" + tutor.getPrecio() + "/h");
        txtDescTutor.setText(tutor.getDescripcion());
    }

    private void loadSubjects(List<MateriaEntity> materias) {
        containerSubjects.removeAllViews();

        LayoutInflater inflater = LayoutInflater.from(getContext());

        for (MateriaEntity m : materias) {
            View view = inflater.inflate(R.layout.item_subject, null);
            TextView txt = view.findViewById(R.id.txtSubject);

            txt.setText(m.getNombre());

            view.setOnClickListener(v -> {
                selectedSubject = m.getMateria_id();
                clearSubjects();
                view.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
            });

            containerSubjects.addView(view);
        }
    }

    private void loadDisponibilidad(List<DisponibilidadEntity> lista) {
        containerMonday.removeAllViews();
        containerTuesday.removeAllViews();
        containerWednesday.removeAllViews();
        containerThursday.removeAllViews();
        containerFriday.removeAllViews();

        LayoutInflater inflater = LayoutInflater.from(getContext());

        for (DisponibilidadEntity d : lista) {
            View view = inflater.inflate(R.layout.item_time_slot, null);
            TextView txt = view.findViewById(R.id.txtTime);

            String rango = d.getHoraInicio() + " - " + d.getHoraFin();
            txt.setText(rango);

            view.setOnClickListener(v -> {
                selectedHorario = rango;
                selectedDia = d.getDiaSemana();
                clearTimes();
                view.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
            });

            switch (d.getDiaSemana().toLowerCase()) {
                case "lunes": containerMonday.addView(view); break;
                case "martes": containerTuesday.addView(view); break;
                case "miercoles": containerWednesday.addView(view); break;
                case "jueves": containerThursday.addView(view); break;
                case "viernes": containerFriday.addView(view); break;
            }
        }
    }

    private void clearSubjects() {
        for (int i = 0; i < containerSubjects.getChildCount(); i++) {
            containerSubjects.getChildAt(i).setBackgroundColor(Color.WHITE);
        }
    }

    private void clearTimes() {
        clearContainer(containerMonday);
        clearContainer(containerTuesday);
        clearContainer(containerWednesday);
        clearContainer(containerThursday);
        clearContainer(containerFriday);
    }

    private void clearContainer(LinearLayout container) {
        for (int i = 0; i < container.getChildCount(); i++) {
            container.getChildAt(i).setBackgroundColor(Color.WHITE);
        }
    }

    private void setupButton() {
        btnRequest.setOnClickListener(v -> {
            if (selectedSubject == -1 || selectedHorario == null) {
                Toast.makeText(getContext(), "Selecciona materia y horario", Toast.LENGTH_SHORT).show();
                return;
            }

            ClaseEntity newClase = new ClaseEntity(alumnoId, tutorId, selectedSubject, selectedDia, selectedHorario, 1, "Pending");

            viewModel.insertarClase(newClase);

            Toast.makeText(getContext(), "Clase solicitada", Toast.LENGTH_SHORT).show();
        });
    }

    private void initViews(View view) {
        containerSubjects = view.findViewById(R.id.containerSubjects);
        containerMonday = view.findViewById(R.id.containerMonday);
        containerTuesday = view.findViewById(R.id.containerTuesday);
        containerWednesday = view.findViewById(R.id.containerWednesday);
        containerThursday = view.findViewById(R.id.containerThursday);
        containerFriday = view.findViewById(R.id.containerFriday);
        btnRequest = view.findViewById(R.id.btnRequest);
        btnBack = view.findViewById(R.id.btnBack);
        txtNameTutor = view.findViewById(R.id.txtNameTutor);
        txtStatsTutor = view.findViewById(R.id.txtStatsTutor);
        txtDescTutor = view.findViewById(R.id.txtDescTutor);
    }

}