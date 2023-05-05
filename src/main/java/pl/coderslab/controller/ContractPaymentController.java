package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.ContractPayment;
import pl.coderslab.service.ContractPaymentService;

import java.sql.Date;

@Controller
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractPaymentController {
    private static final Logger logger = LoggerFactory.getLogger(ContractPaymentController.class);
    private final ContractPaymentService contractPaymentService;

//dodawanie terminu nowego płatności
    @GetMapping("/payment/ins/{contractId}")
    public String contractPaymentNew(@PathVariable Integer contractId, Model model) {
        ContractPayment contractPayment = new ContractPayment();
        contractPayment.setContract(contractPaymentService.getContract(contractId));
        model.addAttribute("contractPayment", contractPayment);
        model.addAttribute("contractPaymentList",
                    contractPaymentService.getContractPaymentsForContract(contractPayment.getContract()));
        return "/contract/payment/paymentForm";
    }

    @PostMapping("/payment/ins/{contractId}")
    public String contractPaymentIns(@PathVariable Integer contractId,
                                     @RequestParam Date paymentDate,
                                     @RequestParam Double paymentValue) {
        ContractPayment cp = new ContractPayment();
        cp.setContract(contractPaymentService.getContract(contractId));
        cp.setPaymentDate(paymentDate);
        cp.setPaymentValue(paymentValue);
        contractPaymentService.contractPaymentSave(cp);
        return "redirect:/contract/payment/ins/{contractId}";
    }
}
