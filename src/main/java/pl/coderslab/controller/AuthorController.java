package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.service.AuthorService;


@Controller
public class AuthorController {

    private final AuthorService aService;
    public AuthorController(AuthorService aService) {
        this.aService = aService;
    }
    @RequestMapping("/author/add")
    @ResponseBody
    public String hello() {
        Author author = new Author();
        author.setFirstName("Bruce");
        author.setLastName("Eckel");
        aService.authorSave(author);
        return "Id dodanego autora to:"
                + author.getId();
    }
    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = aService.authorFindById(id);
        return author.toString();
    }

    @RequestMapping("/author/update/{id}/{fName}/{sName}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String fName, @PathVariable String sName ) {
        Author author = aService.authorFindById(id);
        author.setFirstName(fName);
        author.setLastName(sName);
        aService.authorUpdate(author);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = aService.authorFindById(id);
        aService.authorDelete(author);
        return "deleted";
    }
}
