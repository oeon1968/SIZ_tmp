package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="personDetails")
public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private int streetNumber;
    private String street;
    private String city;



}
