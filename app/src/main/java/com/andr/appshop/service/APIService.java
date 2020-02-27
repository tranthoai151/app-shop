package com.andr.appshop.service;

import com.andr.appshop.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface APIService {

    @GET("/api/v1/products")
    @FormUrlEncoded
    Call<List<Product>> getProducts();
}