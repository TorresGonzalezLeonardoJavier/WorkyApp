package com.example.myfirebaseapp.ui.notifications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myfirebaseapp.MainActivity;
import com.example.myfirebaseapp.R;
import com.example.myfirebaseapp.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.info.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(NotificationsFragment.this)
                        .navigate(R.id.action_navigation_notifications_to_info_usuario);
            }
        });
        binding.plan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(NotificationsFragment.this)
                        .navigate(R.id.action_navigation_notifications_to_plan_usuario);
            }
        });
        binding.stat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        binding.recomendacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(NotificationsFragment.this)
                        .navigate(R.id.action_navigation_notifications_to_recomendaciones_usuario);
            }
        });

        binding.btncontacto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intento = new Intent( Intent.ACTION_SEND);
                intento.setType("text/plain");
                intento.putExtra(Intent.EXTRA_SUBJECT,"asunto");
                intento.putExtra(Intent.EXTRA_TEXT, "Texto del correo");
                intento.putExtra(Intent.EXTRA_EMAIL, new String[] {"workyapp@gmail.com"});
                startActivity( intento );
            }
        });
        binding.boton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intento = new Intent( android.provider.Settings.ACTION_LOCALE_SETTINGS );
                startActivity( intento );
            }
        });


    }
}