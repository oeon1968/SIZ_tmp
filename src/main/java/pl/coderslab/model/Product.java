package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pr_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_group_id")
    private ProductGroup productGroup;
}
