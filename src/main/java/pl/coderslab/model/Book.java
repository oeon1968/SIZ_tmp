package pl.coderslab.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name="books")
@Data

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Size(min = 5)
    private String title;

    @Range(min = 1, max = 10)
    private int rating;

    @Size(max = 500)
    private String description;

    @NotNull
    @ManyToOne
    private Publisher publisher;

    @NotEmpty
    @ManyToMany
    private List<Author> authors;

    @Min(1)
    private int pages;

    @ManyToOne
    private Category category;
}
