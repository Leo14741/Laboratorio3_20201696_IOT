package com.example.laboratorio3_20201696.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laboratorio3_20201696.R;
import com.example.laboratorio3_20201696.databinding.FragmentAcelerometroBinding;

public class Acelerometro extends Fragment {

    FragmentAcelerometroBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAcelerometroBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}