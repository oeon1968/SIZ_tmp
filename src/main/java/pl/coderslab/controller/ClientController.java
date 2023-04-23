package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.model.AccountManager;
import pl.coderslab.model.Client;
import pl.coderslab.model.ClientType;
import pl.coderslab.service.AccountManagerService;
import pl.coderslab.service.ClientService;
import pl.coderslab.service.ClientTypeService;

import java.util.List;


@Controller
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public String clientList(Model model) {
        List<Client> clientList = clientService.getClientList();
        model.addAttribute("clients", clientList);
        return "/client/clientList";
    }

    @GetMapping("/del/{id}")
    public String clientDel(@PathVariable Integer id) {
        clientService.delete(clientService.getClient(id));
        return "redirect:/client";
    }
    //przygotowanie modeli słownikowych
    @ModelAttribute("accountManagers")
    public List<AccountManager> accountManagers() {
        return clientService.accountManagerList();
    }

    @ModelAttribute("clientTypes")
    public List<ClientType> clientTypes() {
       return clientService.clientTypeList();
    }
    //insert
    @GetMapping("/ins")
    public String clientNew(Model model) {
        model.addAttribute("client", new Client());
        return "/client/clientForm";
    }
    @PostMapping("/ins")
    public String clientIns(Client client) {
        clientService.insert(client);
        return "redirect:/client";
    }
    //update
    @GetMapping("/upd/{id}")
    public String clientForm(@PathVariable Integer id, Model model) {
        model.addAttribute("client", clientService.getClient(id));
        return "/client/clientForm";
    }
    @PostMapping("/upd/{id}")
    public String clientUpd(Client client) {
        clientService.update(client);
        return "redirect:/client";
    }
}
