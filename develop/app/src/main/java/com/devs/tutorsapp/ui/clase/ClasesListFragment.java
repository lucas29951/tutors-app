package com.devs.tutorsapp.ui.clase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.data.model.Clase;
import com.devs.tutorsapp.ui.clase.adapter.ClasesAdapter;

import java.util.ArrayList;
import java.util.List;

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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_clases_list, container, false);

        if (getArguments() != null) {
            status = getArguments().getString(ARG_STATUS);
        }

        RecyclerView recyclerView = view.findViewById(R.id.recyclerClases);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ClasesAdapter adapter = new ClasesAdapter(getMockData(status));
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Clase> getMockData(String status) {
        List<Clase> list = new ArrayList<>();

        list.add(new Clase("Dr. Emily Carter", "June 15, 2024", status));
        list.add(new Clase("Mr. David Lee", "June 16, 2024", status));
        list.add(new Clase("Ms. Sarah Chen", "June 17, 2024", status));

        return list;
    }
}