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

import com.example.myfirebaseapp.databinding.FragmentRecomendacionesUsuarioBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link recomendaciones_usuario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class recomendaciones_usuario extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public recomendaciones_usuario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment recomendaciones_usuario.
     */
    // TODO: Rename and change types and number of parameters
    public static recomendaciones_usuario newInstance(String param1, String param2) {
        recomendaciones_usuario fragment = new recomendaciones_usuario();
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
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Recomendaciones");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recomendaciones_usuario, container, false);
        binding = FragmentRecomendacionesUsuarioBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //2 Crear esta variabl
    private FragmentRecomendacionesUsuarioBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ganarPeso.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(recomendaciones_usuario.this)
                        .navigate(R.id.action_recomendaciones_usuario_to_perder_peso2);
            }
        });
        binding.pescado.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(recomendaciones_usuario.this)
                        .navigate(R.id.action_recomendaciones_usuario_to_pescado2);
            }
        });
        binding.frijoles.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(recomendaciones_usuario.this)
                        .navigate(R.id.action_recomendaciones_usuario_to_frijoles2);
            }
        });
        binding.Aguacate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(recomendaciones_usuario.this)
                        .navigate(R.id.action_recomendaciones_usuario_to_aguacate);
            }
        });
        binding.Espinacas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(recomendaciones_usuario.this)
                        .navigate(R.id.action_recomendaciones_usuario_to_espinacas);
            }
        });
    }
}