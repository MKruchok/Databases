package com.mkruchok.model.entity;


import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@SuppressFBWarnings
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class User {
    private Integer id;
    private String email;
    private String userPassword;
    private Timestamp dateCreated;
    private String userName;
    private String groupId;

    public User(String email, String userPassword, Timestamp dateCreated, String userName, String groupId) {
        this.email = email;
        this.userPassword = userPassword;
        this.dateCreated = dateCreated;
        this.userName = userName;
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "\n\nUser: id: " + id + ", email: " + email + ", password: " + userPassword + ", date created: " +
                dateCreated;
    }
}
