package ru.itis.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Nationality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String photoUrl;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "nationality_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
