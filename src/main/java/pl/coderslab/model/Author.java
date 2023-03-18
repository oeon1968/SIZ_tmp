package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToMany(mappedBy = "authors")
            private List<Book> books = new ArrayList<>();
    String firstName;
    String lastName;

    @Override
    public String toString() {
        return firstName+" "+lastName;
    }

}
