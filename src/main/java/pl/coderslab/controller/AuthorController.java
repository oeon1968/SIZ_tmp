package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.service.AuthorService;

@Service
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @RequestMapping("/add")
    @ResponseBody
    public String create() {
        Author author = new Author();
        author.setFirstName("Robert");
        author.setLastName("Nazwisko");
        return "Id autora to:" + author.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String get(@PathVariable long id) {
        Author author = authorService.findById(id);
        return author.toString();
    }

    @RequestMapping("/update/{id}/{title}")
    @ResponseBody
    public String update(@PathVariable long id, @PathVariable String title ) {
        Author author = authorService.findById(id);
        author.setLastName("Nazwisko");
        author.setFirstName("Robert");
        return author.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        Author author = authorService.findById(id);
        authorService.delete(author);
        return "deleted";
    }

}
