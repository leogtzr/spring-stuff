package com.retrofit.client.security;

import com.retrofit.client.domain.Credentials;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SecurityApi {

    @POST("/api/public/auth")
    Call<String> login(@Body Credentials credentials);
}
