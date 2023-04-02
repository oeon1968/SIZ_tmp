package pl.coderslab.model;

import lombok.Data;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name="authors")
public class Author {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    @NotNull
    @PESEL
    private String pesel;

    @NotNull
    @Email
    private String email;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
