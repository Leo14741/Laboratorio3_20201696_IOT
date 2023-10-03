package com.example.laboratorio3_20201696;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.laboratorio3_20201696.R;
import com.example.laboratorio3_20201696.databinding.ActivityMainBinding;
import com.example.laboratorio3_20201696.dto.Picture;
import com.example.laboratorio3_20201696.dto.Result;
import com.example.laboratorio3_20201696.services.TypicodeService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppActivity extends AppCompatActivity {
    private NavController navController;
    private ActivityMainBinding binding;
    TypicodeService typicodeService;
    List<listElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView1);
        navController = navHostFragment.getNavController();

        Button buttonFragment = findViewById(R.id.boton_cambiar_fragment);
        buttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int destination = buttonFragment.getText().equals("Ir a Acelerómetro") ? R.id.acelerometro : R.id.magnetometro;

                navController.navigate(destination);

                buttonFragment.setText(buttonFragment.getText().equals("Ir a Acelerómetro") ? "Ir a Magnetometro" : "Ir a Acelerómetro");
            }
        });

        typicodeService = new Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TypicodeService.class);

        init();

    }
    public void fetchWebServiceData(){
        if(tengoInternet()){
            typicodeService.getResults().enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    //aca estoy en el UI Thread
                    if(response.isSuccessful()){
                        Result result = response.body();
                        Picture picture = new Picture();
                        picture.large = picture.getLarge();
                        picture.medium = picture.getMedium();
                        picture.thumbnail = picture.getThumbnail();
                        ImageView imageView = findViewById(R.id.imageView2); // Reemplaza con el ID de tu ImageView

                        String imageUrl = picture.large; // O puedes usar medium o thumbnail según tus necesidades

                        Picasso.get().load(imageUrl).into(imageView);

                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {

                }
            });
        }
    }
    public void init(){
        elements=new ArrayList<>();


        ListAdapEvent listAdapEvent = new ListAdapEvent(elements,this);
        RecyclerView recyclerView = findViewById(R.id.listMisEventos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapEvent);

    }
    @Override
    public void onBackPressed() {
        String currentFragment = navController.getCurrentDestination().getLabel().toString();
        if (currentFragment.equals("fragment_magnetometro")) {
            finish();
        } else {
            super.onBackPressed();
        }
    }
    public boolean tengoInternet() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        boolean tieneInternet = activeNetworkInfo != null && activeNetworkInfo.isConnected();

        Log.d("msg-test", "Internet: " + tieneInternet);

        return tieneInternet;
    }
}


