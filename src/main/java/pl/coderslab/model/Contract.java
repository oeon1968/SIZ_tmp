package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "contracts")
@Data
public class Contract {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String accountNo;
    private String contractNo;
    private Date contractStart;
    private Date contractFinish;
    private String contractScope;
    private boolean valorization;
    private boolean activeContract;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    //powiązać produkty z kontraktem - relacja "wiele do wielu"

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;
    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;
    @ManyToOne
    @JoinColumn(name = "ctr_type_id")
    private ContractType contractType;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "proj_mgr_id")
    private ProjectManager projectManager;

    //dopisać pomocnicze dane księgowe
    //dopisać powiązanie do przepływów pieniężnych






}