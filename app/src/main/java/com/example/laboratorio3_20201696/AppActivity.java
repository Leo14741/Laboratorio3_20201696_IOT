package com.example.laboratorio3_20201696;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppActivity extends AppCompatActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView1);

        // Obtener el NavController
        navController = navHostFragment.getNavController();

        // Escuchar el clic del botón
        Button buttonFragment = findViewById(R.id.boton_cambiar_fragment);
        buttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar al fragmento correspondiente
                int destination = buttonFragment.getText().equals("Ir a Acelerómetro") ? R.id.acelerometro : R.id.magnetometro;

                navController.navigate(destination);

                // Cambiar el texto del botón
                buttonFragment.setText(buttonFragment.getText().equals("Ir a Acelerómetro") ? "Ir a Magnetometro" : "Ir a Acelerómetro");
            }
        });

        // Escuchar el botón de atrás
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Navegar al destino anterior
                navController.popBackStack(R.id.acelerometro, false);
            }
        });
    }
}