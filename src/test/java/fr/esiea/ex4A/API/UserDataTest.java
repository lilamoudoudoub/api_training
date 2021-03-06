package fr.esiea.ex4A.API;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UserDataTest {
    @ParameterizedTest
    @CsvSource({
        "lila, lila",
        "Nawel, Nawel",
        "Azzedine, Azzedine"
    })
    void creating_a_new_user_with_a_name_should_give_the_same_name(String wantedName, String expectedName){
        UserData userInfo = new UserData("",wantedName,"","","","");
        Assertions.assertThat(userInfo.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource({
        "z@gmail.tn, z@gmail.tn",
        "a@a.com, a@a.com",
        "c@c.pr, c@c.pr",

    })
    void creating_a_new_user_with_an_email_should_give_the_same_email(String wantedValue, String expectedValue){
        UserData userInfo = new UserData(wantedValue, "test", "","","","");
        Assertions.assertThat(userInfo.getEmail()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "pipich, pipich",
        "Alice, Alice"
    })
    void creating_a_new_user_with_a_count_should_give_the_same_count(String wantedValue, String expectedValue){
        UserData userInfo = new UserData("", "test", wantedValue,"","","");
        Assertions.assertThat(userInfo.getTwitter()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "GB, GB",
        "TN, TN",
        "PR, PR"
    })
    void creating_a_new_user_with_a_country_should_give_the_same_country(String wantedValue, String expectedValue){
        UserData userInfo = new UserData(wantedValue, "test", "",wantedValue,"","");
        Assertions.assertThat(userInfo.getCountry()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "M, M",
        "F, F"
    })
    void creating_a_new_user_with_a_sex_should_give_the_same(String wantedValue, String expectedValue){
        UserData userInfo = new UserData(wantedValue, "test", "","",wantedValue,"");
        Assertions.assertThat(userInfo.getSex()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "F, F",
        "M, M"
    })
    void creating_a_new_user_with_a_sexpref_should_give_the_same(String wantedValue, String expectedValue){
        UserData userInfo = new UserData("wantedValue", "test", "","","",wantedValue);
        Assertions.assertThat(userInfo.getSexPref()).isEqualTo(expectedValue);
    }

}
