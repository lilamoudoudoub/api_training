package fr.esiea.ex4A.API;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AgifyServiceTest {
    AgifyClient agifyClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.agify.io/").addConverterFactory(JacksonConverterFactory.create()).build();
        return retrofit.create(AgifyClient.class);
    }
    AgifyClient mockAgifyClient = agifyClient();

    AgifyService agifyService = new AgifyService(mockAgifyClient);
    @Test
    void adding_a_user_should_increment_the_number_of_users() throws IOException {
        UserData userInfo = new UserData("marlon@mail.com", "Marlon", "marlon14", "US", "M", "F");
        agifyService.addUser(userInfo);
        Assertions.assertThat(agifyService.apiRepository.userList.get("MarlonUS")).isEqualTo(userInfo);
        Assertions.assertThat(agifyService.apiRepository.NbrofUsers()).isEqualTo(1);
    }

}
