package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Contract;
import pl.coderslab.model.ContractPayment;

import java.util.List;

public interface ContractPaymentRepository extends JpaRepository<ContractPayment, Integer> {
    List<ContractPayment> readContractPaymentByContract(Contract contract);
    Long countContractPaymentByContract(Contract contract);
}
