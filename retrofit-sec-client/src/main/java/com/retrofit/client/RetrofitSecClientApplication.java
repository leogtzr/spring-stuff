package com.retrofit.client;

import com.retrofit.client.bank.BankClient;
import com.retrofit.client.domain.Credentials;
import com.retrofit.client.security.SecurityApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@SpringBootApplication
public class RetrofitSecClientApplication {
	public static void main(final String[] args) {
		SpringApplication.run(RetrofitSecClientApplication.class, args);

		try {
			final SecurityApi api = BankClient.getRetrofit().create(SecurityApi.class);
			final Call<String> call = api.login(new Credentials("leo", "lein23"));

			final Response<String> response = call.execute();
			//final String body = execute.body();
			// System.out.println("Ok ... ");

			//System.out.println("Body: " + body);

			if (response.isSuccessful()) {
				final String body = response.body();
			} else {
				//error.setText("An error happened, try again later.");
				System.out.println("An error happened, try again later.");
				System.out.println(response.errorBody().string());
			}


		} catch (final IOException ex) {
			ex.printStackTrace();
		}

	}
}

