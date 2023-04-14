package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Data
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cl_abbreviation", nullable = false, length = 15)
    private String client_abbreviation;
    @Column(name = "cl_name")
    private String client_name;
    @ManyToOne
    @JoinColumn(name = "acc_mgr_id")
    private AccountManager accountManager;
    @OneToOne
    @JoinColumn(name = "cl_type_id")
    private ClientType clientType;
}
