package fr.esiea.ex4A.API;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ApiController {
    private final AgifyService agifyService;

    public ApiController(AgifyService agifyService) { this.agifyService = agifyService; }

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody UserData userdata) throws IOException {
        System.out.println(userdata);
        this.agifyService.addUser(userdata);
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserData> getMatchingUsers(@RequestParam(name = "userName", required = true) String name, @RequestParam(name = "userCountry", required = true) String country) {
        List<UserData> userList = this.agifyService.matchUser(name, country);
        return userList;
    }
}
