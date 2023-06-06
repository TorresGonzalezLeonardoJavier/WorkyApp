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

import com.example.myfirebaseapp.databinding.FragmentMostrarBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mostrar#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Mostrar extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Mostrar.
     */
    // TODO: Rename and change types and number of parameters
    public static Mostrar newInstance(String param1, String param2) {
        Mostrar fragment = new Mostrar();
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
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("@string/rutinas");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recomendaciones_usuario, container, false);
        //1 Poner estas 2 lineas_
        binding = FragmentMostrarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //2 Crear esta variable
    private FragmentMostrarBinding binding;

    //3 Finalmente crear el método:
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Mostrar.this)
                        .navigate(R.id.action_mostrar_to_uno);
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Mostrar.this)
                        .navigate(R.id.action_mostrar_to_dos);
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Mostrar.this)
                        .navigate(R.id.action_mostrar_to_tres);
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Mostrar.this)
                        .navigate(R.id.action_mostrar_to_cuatro);
            }
        });
        binding.btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Mostrar.this)
                        .navigate(R.id.action_mostrar_to_cinco);
            }
        });
        binding.btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Mostrar.this)
                        .navigate(R.id.action_mostrar_to_seis);
            }
        });
        binding.btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Mostrar.this)
                        .navigate(R.id.action_mostrar_to_siete);
            }
        });
        binding.btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Mostrar.this)
                        .navigate(R.id.action_mostrar_to_ocho);
            }
        });
        binding.btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Mostrar.this)
                        .navigate(R.id.action_mostrar_to_nueve);
            }
        });

    }
}