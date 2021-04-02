package fr.esiea.ex4A.API;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AgifyUtilisateurTest {
    @ParameterizedTest
    @CsvSource({
        "Ahmed, Ahmed",
        "Amir, Amir",
        "Filepo, Filepo"
    })
    void creating_a_new_agifyuser_with_a_name_should_give_the_same_name(String wantedName, String expectedName){
        AgifyUtilisateur agifyUser = new AgifyUtilisateur(wantedName, 22, 10, "fr");
        Assertions.assertThat(agifyUser.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource({
        "88, 88",
        "18, 18",
        "33, 33"
    })
    void creating_a_new_agifyuser_with_an_age_should_give_the_same_age(int wantedAge, int expectedAge){
        AgifyUtilisateur agifyUser = new AgifyUtilisateur("test", wantedAge, 10, "US");
        Assertions.assertThat(agifyUser.getAge()).isEqualTo(expectedAge);
    }

}
