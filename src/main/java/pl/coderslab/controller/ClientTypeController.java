package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.ClientType;
import pl.coderslab.service.ClientTypeService;

import java.util.List;

@Controller
@RequestMapping("/client_type")
@RequiredArgsConstructor
public class ClientTypeController {
    private final ClientTypeService clientTypeService;
    @RequestMapping( method = RequestMethod.GET)
    public String clientTypeList(Model model) {
        List<ClientType> clientTypeList = clientTypeService.getClientTypeList();
        model.addAttribute("list", clientTypeList);
        return "/dictionary/clientTypeList";
    }
    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String clientTypeDel(@PathVariable int id, Model model) {
         clientTypeService.delete(clientTypeService.getClientType(id));
        return clientTypeList(model);
    }

    @GetMapping(value = "/upd/{id}")
    public String clientTypeForm(@PathVariable int id, Model model) {
        model.addAttribute("clientType", clientTypeService.getClientType(id));
        return "/dictionary/clientTypeForm";
    }

    @PostMapping(value = "/upd/{id}")
    public String clientTypeUpd(ClientType clientType) {
        clientTypeService.update(clientType);
        return "redirect:/client_type";
    }



}
