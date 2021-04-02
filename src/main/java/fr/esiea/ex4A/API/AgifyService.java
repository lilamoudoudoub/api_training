package fr.esiea.ex4A.API;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class AgifyService {

    public final AgifyClient agifyClient;
    public final ApiRepository apiRepository = new ApiRepository();
    private AgifyUtilisateur agifyUtilisateur;

    public AgifyService(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
    }

    public void addUser(UserData utilisateur) throws IOException {
        if(!apiRepository.seeIfUserExists(utilisateur)){
            agifyUtilisateur = this.agifyClient.getUserAge(utilisateur.name, utilisateur.country).execute().body();
            apiRepository.addNewUser(utilisateur, agifyUtilisateur);
        }
    }

    public ArrayList<UserData> matchUser(String userName, String userCountry){
        UserData userRequestingMatch = apiRepository.getUser(userName, userCountry);
        if(userRequestingMatch != null){
            return apiRepository.matchUser(userRequestingMatch);
        } else {
            return new ArrayList<>();
        }
    }
}
