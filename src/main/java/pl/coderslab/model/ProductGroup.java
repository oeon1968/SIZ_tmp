package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product_groups")
@Data
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "group_name")
    private String name;
}
