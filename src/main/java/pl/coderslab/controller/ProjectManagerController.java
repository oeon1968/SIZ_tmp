package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.ProjectManager;
import pl.coderslab.service.ProjectManagerService;

import java.util.List;

@Controller
@RequestMapping("/project_manager")
@RequiredArgsConstructor
public class ProjectManagerController {
    private final ProjectManagerService projectManagerService;

    @RequestMapping(method = RequestMethod.GET)
    public String projectManagerList(Model model) {
        List<ProjectManager> projectManagerList = projectManagerService.getProjectManagerList();
        model.addAttribute("List", projectManagerList);
        return "/dictionary/projectManagerList";
    }

    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        projectManagerService.delete(projectManagerService.getProjectManager(id));
        return projectManagerList(model);
    }

    @GetMapping(value = "/upd/{id}")
    public String projectManagerForm(@PathVariable Integer id, Model model) {
        model.addAttribute("projectManager", projectManagerService.getProjectManager(id));
        return "/dictionary/projectManagerForm";
    }

    @PostMapping(value = "/upd/{id}")
    public String projectManagerUpd(ProjectManager projectManager) {
        projectManagerService.update(projectManager);
        return "redirect:/project_manager";
    }

    @GetMapping(value = "/ins")
    public String projectManagerNew(Model model) {
        model.addAttribute("projectManager", new ProjectManager());
        return "/dictionary/projectManagerForm";
    }

    @PostMapping(value = "/ins")
    public String projectManagerIns(ProjectManager projectManager) {
        projectManagerService.insert(projectManager);
        return "redirect:/project_manager";
    }

}
