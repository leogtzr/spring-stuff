package com.retrofit.client.bank;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// TODO: Change for an enum ...
public class BankClient {

    private static Retrofit RETROFIT;

    public static final String SERVICE_BASE_URL = "http://127.0.0.1:8080/";

    public static Retrofit getRetrofit() {
        if (RETROFIT == null) {
            getClient();
        }
        return RETROFIT;
    }

    private static void getClient() {
        final Gson gson = new GsonBuilder().setLenient().create();
        RETROFIT = new Retrofit.Builder()
                .baseUrl(SERVICE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
