package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


}
