package com.example.myfirebaseapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfirebaseapp.databinding.FragmentPerderPesoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link perder_peso#newInstance} factory method to
 * create an instance of this fragment.
 */
public class perder_peso extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public perder_peso() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment perder_peso.
     */
    // TODO: Rename and change types and number of parameters
    public static perder_peso newInstance(String param1, String param2) {
        perder_peso fragment = new perder_peso();
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
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Perder peso");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perder_peso, container, false);
        binding = FragmentPerderPesoBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    private FragmentPerderPesoBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.perderPeso.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(perder_peso.this)
                        .navigate(R.id.action_perder_peso2_to_recomendaciones_usuario);
            }
        });
        binding.frutos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(perder_peso.this)
                        .navigate(R.id.action_perder_peso2_to_frutos2);
            }
        });
        binding.aceite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(perder_peso.this)
                        .navigate(R.id.action_perder_peso2_to_aceite2);
            }
        });
        binding.Pan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(perder_peso.this)
                        .navigate(R.id.action_perder_peso2_to_pan);
            }
        });
        binding.agua.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(perder_peso.this)
                        .navigate(R.id.action_perder_peso2_to_aguacate2);
            }
        });
    }
}