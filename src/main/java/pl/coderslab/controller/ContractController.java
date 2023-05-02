package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.service.ContractService;

import java.util.List;


@Controller
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    //słowniki uzupełniające
    @ModelAttribute("clients")
    public List<Client> clients() {
        return contractService.clients();
    }
    @ModelAttribute("paymentMethods")
    public List<PaymentMethod> paymentMethods() {
        return contractService.paymentMethods();
    }
    @ModelAttribute("sectors")
    public List<Sector> sectors() {
        return contractService.sectors();
    }
    @ModelAttribute("contractTypes")
    public List<ContractType> contractTypes() {
        return contractService.contractTypes();
    }
    @ModelAttribute("products")
    public List<Product> products() {
        return contractService.products();
    }
    @ModelAttribute("projectManagers")
    public List<ProjectManager> projectManagers() {
        return contractService.projectManagers();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String contractList(Model model) {
        model.addAttribute("Contracts", contractService.getContractList());
        return "/contract/contractList";
    }

    @GetMapping("/ins")
    public String contractNew(Model model) {
        model.addAttribute("Contract", new Contract());
        return "/contract/contractForm";
    }
    //dopisać metodę post
    @PostMapping("/ins")
    @ResponseBody
    //jest błąd
    public String ContractIns(Contract contract) {
        contractService.insert(contract);
        return contract.toString();
    }

    @GetMapping("/upd/{id}")
    public String contractNew(@PathVariable Long id, Model model) {
        model.addAttribute("Contract", contractService.getContract(id));
        return "/contract/contractForm";
    }
    //dopisać metodę post
}
