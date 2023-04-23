package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.ContractType;
import pl.coderslab.service.ContractTypeService;

import java.util.List;

@Controller
@RequestMapping("/contract_type")
@RequiredArgsConstructor
public class ContractTypeController {
    private final ContractTypeService contractTypeService;

    @RequestMapping(method = RequestMethod.GET)
    public String contractTypeList(Model model) {
        List<ContractType> contractTypeList = contractTypeService.getContractTypeList();
        model.addAttribute("List", contractTypeList);
        return "/dictionary/contractTypeList";
    }

    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable Integer id) {
        contractTypeService.delete(contractTypeService.getContractType(id));
        return "redirect:/contract_type";
    }

    @GetMapping(value = "/upd/{id}")
    public String contractTypeForm(@PathVariable Integer id, Model model) {
        model.addAttribute(contractTypeService.getContractType(id));
        return "/dictionary/contractTypeForm";
    }

    @PostMapping(value = "upd/{id}")
    public String contractTypeUpd(ContractType contractType) {
        contractTypeService.update(contractType);
        return "redirect:/contract_type";
    }

    @GetMapping(value = "/ins")
    public String contractTypeNew(Model model) {
        model.addAttribute("contractType", new ContractType());
        return "/dictionary/contractTypeForm";
    }

    @PostMapping(value = "/ins")
    public String contractTypeIns(ContractType contractType) {
        contractTypeService.insert(contractType);
        return "redirect:/contract_type";
    }
}
