package com.devs.tutorsapp.ui.tutor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.data.model.Tutor;
import com.devs.tutorsapp.ui.tutor.adapter.TutorAdapter;

import java.util.ArrayList;
import java.util.List;

public class TutorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private TutorAdapter adapter;
    private List<Tutor> tutorList;

    public TutorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TutorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TutorFragment newInstance(String param1, String param2) {
        TutorFragment fragment = new TutorFragment();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tutor, container, false);

        recyclerView = view.findViewById(R.id.recyclerTutores);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        cargarDatos();

        adapter = new TutorAdapter(tutorList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void cargarDatos() {
        tutorList = new ArrayList<>();

        tutorList.add(new Tutor(
                "Juan",
                "Pérez",
                "$160.00/h",
                "Profesor con 5 años de experiencia en nivel secundario."
        ));

        tutorList.add(new Tutor(
                "María",
                "Gómez",
                "$250.00/h",
                "Desarrolladora y docente universitaria."
        ));

        tutorList.add(new Tutor(
                "Carlos",
                "López",
                "$85.00/h",
                "Clases personalizadas para todos los niveles."
        ));
    }
}