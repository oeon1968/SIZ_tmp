package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.ContractTypeDao;
import pl.coderslab.model.ClientType;
import pl.coderslab.model.ContractType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractTypeService {
    private final ContractTypeDao ct;
    public void insert (ContractType contractType) {
        ct.insert(contractType);
    }

    public void update (ContractType contractType) {
        ct.update(contractType);
    }

    public void delete (ContractType contractType) {
        ct.delete(contractType);
    }

    public List<ContractType> getContractTypeList() {
        return  ct.contractTypeList();
    }

    public ContractType getContractType(int id) {
        return ct.findObject(id);
    }
}
