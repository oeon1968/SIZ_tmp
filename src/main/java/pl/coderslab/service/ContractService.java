package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.*;
import pl.coderslab.model.*;

import javax.print.attribute.IntegerSyntax;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractDao contractDao;
    private final ContractTypeService contractTypeService;
    private final ClientService clientService;
    private final PaymentMethodService paymentMethodService;

    private final SectorService sectorService;
    private final ProductService productService;
    private final ProjectManagerService projectManagerService;

    public void insert(Contract contract) {
        contractDao.insert(contract);
    }

    public void update(Contract contract) {
        contractDao.update(contract);
    }

    public void delete(Contract contract) {
        contractDao.delete(contract);
    }

    public Contract getContract(Integer id) {
        return contractDao.findObject(id);
    }

    public List<Contract> getContractList() {
        return contractDao.contractList();
    }

    //listy uzupełniające
    public List<ContractType> contractTypes() {
        return contractTypeService.getContractTypeList();
    }

    public List<Client> clients() {
        return clientService.getClientList();
    }

    public List<PaymentMethod> paymentMethods() {
        return paymentMethodService.getPaymentMethodList();
    }

    public List<Sector> sectors() {
        return sectorService.getSectorList();
    }

    public List<Product> products() {
        return productService.getProductList();
    }

    public List<ProjectManager> projectManagers() {
        return projectManagerService.getProjectManagerList();
    }

}
