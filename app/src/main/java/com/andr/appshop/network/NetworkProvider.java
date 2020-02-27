package com.andr.appshop.network;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkProvider {
    private static volatile NetworkProvider mInstance = null;
    private Retrofit retrofit;

    private NetworkProvider() {
        retrofit = new Retrofit.Builder()
                .baseUrl("5e57e4164c695f0014330247.mockapi.io")
                .client(new OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();
    }

    public static NetworkProvider self() {
        if (mInstance == null)
            mInstance = new NetworkProvider();
        return mInstance;
    }
}

