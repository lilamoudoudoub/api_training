package fr.esiea.ex4A.API;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiRepositoryTest {
    private final ApiRepository apiRepository = new ApiRepository();

    @Test
    void having_no_users_should_return_no_users(){
        Assertions.assertThat(apiRepository.NbrofUsers()).isEqualTo(0);
    }

    @Test
    void adding_a_user_to_repository_increments_number_of_users(){
        UserData userInfo = new UserData("test", "test", "test", "test", "test", "test");
        AgifyUtilisateur agifyUser = new AgifyUtilisateur("test", 50, 500, "US");
        apiRepository.addNewUser(userInfo, agifyUser);
        Assertions.assertThat(apiRepository.NbrofUsers()).isEqualTo(1);
    }

    @Test
    void adding_multiple_users_should_increment_the_number_of_users(){
        UserData userData1 = new UserData("t1", "te1", "tes1", "test1", "test1", "test1");
        UserData userData2 = new UserData("e2", "n2", "tw2", "test2", "test3", "test3");
        UserData userData3 = new UserData("e7", "n6", "tw3", "test3", "test3", "test3");
        UserData userData4 = new UserData("e4", "n4", "tw4", "test4", "test3", "test3");

        AgifyUtilisateur agifyUser1 = new AgifyUtilisateur("bb", 90, 300, "FR");
        AgifyUtilisateur agifyUser2 = new AgifyUtilisateur("cc", 66, 522, "AL");
        AgifyUtilisateur agifyUser3 = new AgifyUtilisateur("dd", 22, 66, "EN");
        AgifyUtilisateur agifyUser4 = new AgifyUtilisateur("Jd", 29, 67, "EH");
        apiRepository.addNewUser(userData1, agifyUser1);
        apiRepository.addNewUser(userData2, agifyUser2);
        apiRepository.addNewUser(userData3, agifyUser3);
        apiRepository.addNewUser(userData4, agifyUser4);
        Assertions.assertThat(apiRepository.NbrofUsers()).isEqualTo(4);
        Assertions.assertThat(4).isEqualTo(4);
    }

}
