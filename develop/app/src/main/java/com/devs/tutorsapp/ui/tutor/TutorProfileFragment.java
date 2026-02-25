package com.devs.tutorsapp.ui.tutor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.ui.clase.ReservaClaseFragment;
import com.devs.tutorsapp.ui.viewmodel.TutorViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TutorProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TutorProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView tvTutorName, tvTutorDescription, tvTutorPrice;
    private Button btnRequestClass, btnBackToTutors;
    private TutorViewModel tutorViewModel;
    private int tutorId;

    public TutorProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TutorProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TutorProfileFragment newInstance(String param1, String param2) {
        TutorProfileFragment fragment = new TutorProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_tutor_profile, container, false);

        tvTutorName = view.findViewById(R.id.tvNameTutor);
        tvTutorDescription = view.findViewById(R.id.tvTutorDescription);
        tvTutorPrice = view.findViewById(R.id.tvTutorPrice);
        btnRequestClass = view.findViewById(R.id.btnRequestClass);

        tutorViewModel = new ViewModelProvider(this).get(TutorViewModel.class);

        if (getArguments() != null) {
            tutorId = getArguments().getInt("tutorId");
        }

        tutorViewModel.getTutorById(tutorId).observe(getViewLifecycleOwner(), tutor -> {
            if (tutor != null) {
                tvTutorName.setText(tutor.getNombre() + " " + tutor.getApellido());
                tvTutorDescription.setText(tutor.getDescripcion());
                tvTutorPrice.setText("$ " + tutor.getPrecio() + "/h");
            }
        });

        btnRequestClass.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("tutorId", tutorId);

            ReservaClaseFragment reservaClaseFragment = new ReservaClaseFragment();
            reservaClaseFragment.setArguments(bundle);

            NavController navController = NavHostFragment.findNavController(TutorProfileFragment.this);

            navController.navigate(R.id.reservaClaseFragment, bundle);
        });

        return view;
    }

}