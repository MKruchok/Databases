package com.mkruchok.model.entity;


import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@SuppressFBWarnings
@Getter
@Setter
public final class User {
    private Integer id;
    private String email;
    private String password;
    private Timestamp dateCreated;
    private String name;
    private String groupId;

    public User(Integer id, String email, String password, Timestamp dateCreated, String name, String groupId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.dateCreated = dateCreated;
        this.name = name;
        this.groupId = groupId;
    }

    public User(String email, String password, Timestamp dateCreated, String name, String groupId) {
        this.email = email;
        this.password = password;
        this.dateCreated = dateCreated;
        this.name = name;
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "\n\nUser: id: " + id + ", email: " + email + ", password: " + password + ", date created: " +
                dateCreated;
    }
}
