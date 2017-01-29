package pl.pb.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String login;

    private String password;

    @OneToMany
    private List<Project> projects;
}