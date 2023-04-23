package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.ClientDao;
import pl.coderslab.model.Sector;
import pl.coderslab.service.SectorService;

import java.util.List;

@Controller
@RequestMapping(value = "/sector")
@RequiredArgsConstructor
public class SectorController {
    private final SectorService sectorService;
    @GetMapping()
    public String sectorList(Model model) {
        List<Sector> sectorList = sectorService.getSectorList();
        model.addAttribute("List", sectorList);
        return "dictionary/sectorList";
    }
    @GetMapping(value = "/del/{id}")
    public String sectorDel(@PathVariable int id) {
        sectorService.delete(sectorService.getSector(id));
        return "redirect:/sector";
    }

    @GetMapping(value = "/upd/{id}")
    public String sectorForm(@PathVariable int id, Model model) {
        model.addAttribute("sector", sectorService.getSector(id));
        return "/dictionary/sectorForm";
    }

    @PostMapping(value = "/upd/{id}")
    public String sectorUpd(Sector sector) {
        sectorService.update(sector);
        return "redirect:/sector";
    }

    @GetMapping(value = "/ins")
    public String sectorNew(Model model) {
        model.addAttribute("sector", new Sector());
        return "/dictionary/sectorForm";
    }

    @PostMapping(value = "/ins")
    public String sectorIns(Sector sector) {
        sectorService.insert(sector);
        return "redirect:/sector";
    }

}
