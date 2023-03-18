package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    @RequestMapping("/add")
    @ResponseBody
    public String create() {
        List <Author> authors = new ArrayList<>();

        authors.add(authorService.findById(1));
        authors.add(authorService.findById(2));

        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setRating(8);
        book.setDescription("Ale nuda");
     //   book.setAuthors(authors);
        bookService.save(book);
        return "Id dodanej książki to:" + book.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String get(@PathVariable long id) {
        Book book = bookService.findById(id);
        return book.toString();
    }

    @RequestMapping("/update/{id}/{title}")
    @ResponseBody
    public String update(@PathVariable long id, @PathVariable String title ) {
        Book book = bookService.findById(id);
        book.setTitle(title);
        bookService.update(book);
        return book.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookService.findById(id);
        bookService.delete(book);
        return "deleted";
    }
}
