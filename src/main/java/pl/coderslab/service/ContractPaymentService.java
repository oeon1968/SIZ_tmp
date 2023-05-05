package pl.coderslab.service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Contract;
import pl.coderslab.model.ContractPayment;
import pl.coderslab.repository.ContractPaymentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractPaymentService {
    private final ContractPaymentRepository contractPaymentRepository;
    private final ContractService contractService;
//select
    public ContractPayment getContractPayment(Integer id) {
        return contractPaymentRepository.getOne(id);
    }

    public List<ContractPayment> getContractPaymentList() {
        return contractPaymentRepository.findAll();
    }
    public List<ContractPayment> getContractPaymentsForContract(Contract contract) {
        return contractPaymentRepository.readContractPaymentByContract(contract);
    }
    public Contract getContract(Integer id) {
        return contractService.getContract(id);
    }
    public Long countContractPaymentByContract(Contract contract) {
        return contractPaymentRepository.countContractPaymentByContract(contract);
    }


//insert and update
    @Modifying
    @Transactional
    public void contractPaymentSave(ContractPayment contractPayment) {
        contractPaymentRepository.save(contractPayment);
    }

//delete
    @Modifying
    @Transactional
    public void contractPaymentDel(Integer id) {
        contractPaymentRepository.deleteById(id);
    }

}
