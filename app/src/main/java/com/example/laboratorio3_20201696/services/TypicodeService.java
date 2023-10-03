package com.example.laboratorio3_20201696.services;

import com.example.laboratorio3_20201696.dto.Info;
import com.example.laboratorio3_20201696.dto.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TypicodeService {

    @GET("/api/")
    Call<Result> getResults();

}
