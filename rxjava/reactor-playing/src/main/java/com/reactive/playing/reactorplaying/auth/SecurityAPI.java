package com.reactive.playing.reactorplaying.auth;

import com.reactive.playing.reactorplaying.domain.Credentials;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SecurityAPI {

    @POST("/api/public/auth")
    Call<String> login(@Body Credentials credentials);

}
