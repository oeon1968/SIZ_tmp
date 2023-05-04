package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.service.ContractService;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;


@Controller
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {
    private static final Logger logger = LoggerFactory.getLogger(ContractController.class);
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
    @PostMapping("/ins")
    public String contractIns(@Valid Contract contract, BindingResult resultValidation,
                              @RequestParam Date start,
                              @RequestParam Date finish) {
        contract.setContractStart(start);
        contract.setContractFinish(finish);
        if(resultValidation.hasErrors()) {
            return "/ins";
        }
        contractService.insert(contract);
        return "redirect:/contract";
    }

    @GetMapping("/upd/{id}")
    public String contractNew(@PathVariable Integer id, Model model) {
        model.addAttribute("Contract", contractService.getContract(id));
        return "/contract/contractForm";
    }
    @PostMapping("/upd/{id}")
    public String contractUpd (@Valid Contract contract, BindingResult resultValidation,
                               @RequestParam Date start,
                               @RequestParam Date finish) {
        //sprawdzić zastosowanie konwertera
        contract.setContractStart(start);
        contract.setContractFinish(finish);
        if(resultValidation.hasErrors()) {
            return "contract/contractForm";
        }
        contractService.update(contract);
        return "redirect:/contract";
    }

    @GetMapping("/del/{id}")
    public String contractDel(@PathVariable Integer id) {
        contractService.delete(contractService.getContract(id));
        return "redirect:/contract";
    }


}
