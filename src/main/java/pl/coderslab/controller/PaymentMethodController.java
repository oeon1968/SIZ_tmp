package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.PaymentMethod;
import pl.coderslab.service.PaymentMethodService;

import java.util.List;

@Controller
@RequestMapping("/payment_method")
@RequiredArgsConstructor
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    @RequestMapping(method = RequestMethod.GET)
    public String paymentMethodList(Model model) {
        List<PaymentMethod> paymentMethodList = paymentMethodService.getPaymentMethodList();
        model.addAttribute("List", paymentMethodList);
        return "/dictionary/paymentMethodList";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String paymentMethodDel(@PathVariable int id) {
        paymentMethodService.delete(paymentMethodService.getPaymentMethod(id));
        return "redirect:/payment_method";
    }

    @RequestMapping(value = "/upd/{id}")
    public String paymentMethodForm(@PathVariable int id, Model model) {
        model.addAttribute("paymentMethod", paymentMethodService.getPaymentMethod(id));
        return "/dictionary/paymentMethodForm";
    }

    @PostMapping(value = "/upd/{id}")
    public String paymentMethodUpd(PaymentMethod paymentMethod) {
        paymentMethodService.update(paymentMethod);
        return "redirect:/payment_method";
    }

    @GetMapping(value = "/ins")
    public String paymentMethodNew(Model model) {
        model.addAttribute("paymentMethod", new PaymentMethod());
        return "/dictionary/paymentMethodForm";
    }

    @PostMapping(value = "/ins")
    public String paymentMethodIns(PaymentMethod paymentMethod) {
        paymentMethodService.insert(paymentMethod);
        return "redirect:/payment_method";
    }

}
