package fr.esiea.ex4A.API;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static org.junit.jupiter.api.Assertions.*;

class AgifyClientTest {
    private final AgifyClient agifyClient;

    AgifyClientTest() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create()).build();
        this.agifyClient = retrofit.create(AgifyClient.class);
    }

    @ParameterizedTest
    @CsvSource({
        "lila, PR, 36",
        "Mazigh, TN, 69",
        "Azzedine, AL, 48",
        "Nawel, VE, 33"
    })

    void getAgeFromNames(String userName, String userCountry, int expectedAge){
        Call<AgifyUtilisateur> call = this.agifyClient.getUserAge(userName, userCountry);
        (call).enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<AgifyUtilisateur> call, Response<AgifyUtilisateur> response) {
                if (response.isSuccessful() && response.body() != null) {
                    AgifyUtilisateur agifyUser = response.body();
                    agifyUser.getAge();
                }
            }

            @Override
            public void onFailure(Call<AgifyUtilisateur> call, Throwable throwable) {
                System.out.println("Error on API");
            }
        });
    }



}
