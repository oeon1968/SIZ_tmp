package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.AccountManager;
import pl.coderslab.service.AccountManagerService;

import java.util.List;

@Controller
@RequestMapping("/account_manager")
@RequiredArgsConstructor
public class AccountManagerController {
    private final AccountManagerService accountManagerService;

    @RequestMapping(method = RequestMethod.GET)
    public String accountManagerList(Model model) {
        List<AccountManager> accountManagerList = accountManagerService.getAccountManagerList();
        model.addAttribute("List", accountManagerList);
        return "/dictionary/accountManagerList";
    }

    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        accountManagerService.delete(accountManagerService.getAccountManager(id));
        return accountManagerList(model);
    }

    @GetMapping(value = "/upd/{id}")
    public String accountManagerForm(@PathVariable Integer id, Model model) {
        model.addAttribute("accountManager", accountManagerService.getAccountManager(id));
        return "/dictionary/accountManagerForm";
    }

    @PostMapping(value = "/upd/{id}")
    public String accountManagerUpd(AccountManager accountManager) {
        accountManagerService.update(accountManager);
        return "redirect:/account_manager";
    }

    @GetMapping(value = "/ins")
    public String accountManagerNew(Model model) {
        model.addAttribute("accountManager", new AccountManager());
        return "/dictionary/accountManagerForm";
    }

    @PostMapping(value = "/ins")
    public String accountManagerIns(AccountManager accountManager) {
        accountManagerService.insert(accountManager);
        return "redirect:/account_manager";
    }

}
