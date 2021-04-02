package fr.esiea.ex4A.API;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AgifyUtilisateur {


    public final String Iduser;
    public final String name;
    public final Integer age;
    public final Integer count;
    public final String idcountry;

    public AgifyUtilisateur(@JsonProperty("name") String name, @JsonProperty("age") int age, @JsonProperty("count") int count, @JsonProperty("country_id") String country_id) {
        this.name = name;
        this.age = age;
        this.count = count;
        this.idcountry = country_id;
        this.Iduser = name.concat(country_id);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCount() {
        return count;
    }

    public String getIdcountry() {
        return idcountry;
    }

    public String getIduser(){ return this.Iduser; }

}
