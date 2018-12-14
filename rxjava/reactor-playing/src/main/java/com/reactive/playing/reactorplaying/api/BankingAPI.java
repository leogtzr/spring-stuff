package com.reactive.playing.reactorplaying.api;

import com.reactive.playing.reactorplaying.domain.BalanceInformation;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.GET;

public interface BankingAPI {
    @GET("/api/secure/balance")
    Call<BalanceInformation> queryBalance(@Header("x-auth-token") String token);
}
