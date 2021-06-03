package ru.itis.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String last_name;

    private String email;

    private String hashPassword;
    private Long point;
    private String confirmCode;

    @ManyToMany(mappedBy = "users")
    private List<Team> teams;

//    @ManyToMany(mappedBy = "users")
//    List<Nationality> nationalities;

    private String nationality;


    private String city;

    private String photoUrl;


    public String getPhotoUrl() {
        if (photoUrl != null)
        return photoUrl;
        else return null;
    }

    @Enumerated(value = EnumType.STRING)
    private Confirm confirm;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public enum Confirm{
        CONFIRM, NOT_CONFIRM
    }

    public enum State {
        ACTIVE, BANNED
    }

    public enum Role {
        USER, ADMIN
    }

    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public boolean isBanned() {
        return this.state == State.BANNED;
    }

    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }

}
