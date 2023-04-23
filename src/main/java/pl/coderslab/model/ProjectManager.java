package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "project_managers")
@Data
public class ProjectManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
