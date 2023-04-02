package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/book/form")
@RequiredArgsConstructor
public class BookFormController {
    private final PublisherService publisherService;
    private final BookService bookService;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "/book/form";
    }

    @PostMapping("/add")
    public String addSave(@Valid Book book, BindingResult result) {
        if(result.hasErrors()) {

            return "/book/form";
        }
        bookService.saveBook(book);

        return "redirect:/book/all";
    }

    @GetMapping("/mod/{id}")
    public String mod(Model model, @PathVariable long id) {

        model.addAttribute("book", bookService.findById(id));
        return "/book/form";
    }

    @PostMapping("/mod/{id}")
    public String update( @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/mod/{id}";
        }
        bookService.update(book);
        return "redirect:/book/all";
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherService.all();
    }
}
