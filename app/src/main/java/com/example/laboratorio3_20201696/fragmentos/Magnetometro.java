package com.example.laboratorio3_20201696.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laboratorio3_20201696.R;
import com.example.laboratorio3_20201696.databinding.FragmentMagnetometroBinding;

public class Magnetometro extends Fragment {

    FragmentMagnetometroBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMagnetometroBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}