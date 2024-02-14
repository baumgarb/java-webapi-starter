package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("id")
    public final int id;
    @JsonProperty("name")
    public final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }   
}
