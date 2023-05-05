package pl.coderslab.model;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;



@Entity
@Table(name = "contracts")
@Data
public class Contract {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String accountNo;
    private String contractNo;
    //@DateTimeFormat
    private Date contractStart;
    private Date contractFinish;
    private String contractScope;
    private Boolean valorization;
    private Boolean activeContract;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
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
