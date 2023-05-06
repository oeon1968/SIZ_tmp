package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "contract_payments")
@Data
public class ContractPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Date paymentDate;
    @NotNull
    @Min(value = 0)
    private Double paymentValue;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;
}
