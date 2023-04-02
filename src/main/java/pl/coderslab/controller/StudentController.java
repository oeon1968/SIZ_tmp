package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/form")
    public  String form(Model model) {
        model.addAttribute("student", new Student());
        return "/student";
    }

    @ModelAttribute("countryItems")
    public List<String> countries() {
        return Arrays.asList("Poland", "German", "France", "Russia", "Denmark");
    }

    @ModelAttribute("skillsList")
    public List<String> programmingSkills() {
        return Arrays.asList("PHP", "JAVA", "C#", "Pyton");
    }

    @ModelAttribute ("hobbiesList")
        public List<String> hobbies() {
        return Arrays.asList("books", "travels", "asians food");
        }

}
