package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "account_managers")
@Data
public class AccountManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public String getName() {
        return firstName+" "+lastName;
    }
}

