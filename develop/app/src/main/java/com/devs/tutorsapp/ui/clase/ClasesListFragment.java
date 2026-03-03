package com.devs.tutorsapp.ui.clase;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.ui.clase.adapter.ClasesAdapter;
import com.devs.tutorsapp.ui.viewmodel.ClaseViewModel;
import com.devs.tutorsapp.ui.viewmodel.SessionViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClasesListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClasesListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_STATUS = "status";
    private String status;
    private ClaseViewModel viewModel;
    private ClasesAdapter adapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ClasesListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ClasesListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClasesListFragment newInstance(String status) {
        ClasesListFragment fragment = new ClasesListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_STATUS, status);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            status = getArguments().getString(ARG_STATUS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_clases_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerClases);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new ClasesAdapter(item -> {
            Bundle bundle = new Bundle();
            bundle.putInt("clase_id", item.getClase_id());

            NavController navController = Navigation.findNavController(requireActivity(), R.id.fragment_container);
            navController.navigate(R.id.claseDetalleFragment, bundle);
        });
        recyclerView.setAdapter(adapter);

        if (getArguments() != null) {
            status = getArguments().getString(ARG_STATUS);
        } else {
            status = "Pending";
        }

        viewModel = new ViewModelProvider(this).get(ClaseViewModel.class);

        SessionViewModel session = new ViewModelProvider(requireActivity()).get(SessionViewModel.class);

        session.getAlumnoId().observe(getViewLifecycleOwner(), id -> {
            if (id == null || id <= 0) {
                return;
            }

            viewModel.getClasesConDetalles(status, id).observe(getViewLifecycleOwner(), clases -> {
                adapter.setData(clases);
            });
        });

    }

}