package fr.esiea.ex4A.API;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Repository
public class ApiRepository {
    final HashMap<String, UserData> userList = new HashMap<>();
    final HashMap<String, AgifyUtilisateur> userAge = new HashMap<>();

    int NbrofUsers(){
        return this.userList.size();
    }

    void addNewUser(UserData userData, AgifyUtilisateur userAge){
        this.userList.put(userData.getUserId(), userData);
        this.userAge.put(userData.getUserId(), userAge);
    }

    boolean seeIfUserExists(UserData datauser){
        return this.userList.containsKey(datauser.getUserId());
    }

    UserData getUser(String userName, String countryId){
        return this.userList.get(userName.concat(countryId));
    }

    ArrayList<UserData> matchUser(UserData userData){
        ArrayList<UserData> matchingUsers = new ArrayList<>();
        for(Map.Entry<String, AgifyUtilisateur> userEntry : this.userAge.entrySet()){
            if(Math.abs(userEntry.getValue().getAge() - this.userAge.get(userData.getUserId()).getAge()) <= 4){
                UserData possiblyMatchingUser = this.userList.get(userEntry.getValue().getIduser());
                if(possiblyMatchingUser.getSex().equals(userData.getSexPref()) && userData.getSex().equals(possiblyMatchingUser.getSexPref())) {
                    matchingUsers.add(this.userList.get(userEntry.getValue().getIduser()));
                }
            }
        }
        return matchingUsers;
    }
}
