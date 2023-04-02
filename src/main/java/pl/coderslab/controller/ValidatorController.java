package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class ValidatorController {
    private final Validator validator;

    @RequestMapping("/validate/book")
    //@ResponseBody
    public String validate(Model model) {
        Book book = new Book();

        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        model.addAttribute("errors", violations);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> violation: violations) {
                System.out.println(violation.getPropertyPath()+":"+violation.getMessage());
            }
        }
        return "/validation/list";
    }
    @RequestMapping("/validate/author")
    public String validateAuthor(Model model) {
        Author author = new Author();
        Set<ConstraintViolation<Author>> violations = validator.validate(author);
        model.addAttribute("errors", violations);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Author> violation: violations) {
                System.out.println(violation.getPropertyPath()+":"+violation.getMessage());
            }
        }
        return "/validation/list";
    }

    @RequestMapping("/validate/publisher")
    public String validatePublisher(Model model) {
        Publisher publisher = new Publisher();
        Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher);
        model.addAttribute("errors", violations);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Publisher> violation: violations) {
                System.out.println(violation.getPropertyPath()+":"+violation.getMessage());
            }
        }
        return "/validation/list";
    }

}
