package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id", unique = true)
    private PersonDetails personDetails;
}
