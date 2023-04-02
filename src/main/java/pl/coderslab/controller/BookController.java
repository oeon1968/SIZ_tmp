package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService ;

    @RequestMapping("/add")
    @ResponseBody
    public String create() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherService.save(publisher);

        Author author1 = new Author();
        author1.setFirstName("Adam");
        author1.setLastName("Mickiewicz");
        authorService.authorSave(author1);

        Author author2 = new Author();
        author2.setFirstName("Henryk");
        author2.setLastName("Sienkiewicz");
        authorService.authorSave(author2);

        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setDescription("Nowa książka");
        book.setPublisher(publisher);
        book.setAuthors(authors);
        bookService.saveBook(book);
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
    public String delete(@PathVariable long id) {
        Book book = bookService.findById(id);
        bookService.delete(book);
        return "deleted";
    }

    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("books", bookService.allWithAuthors());
        return "/book/list";
    }

    @RequestMapping("/all/rating/{rating}")
    @ResponseBody
    public String allWithRating(@PathVariable int rating) {
        return bookService.allWithRating(rating).toString();
    }

/*    @RequestMapping("/all/publisher")
    @ResponseBody
    public String getBookWithPublisher() {
        return bookService.get
    }*/

    @RequestMapping("/all/publisher/{id}")
    @ResponseBody
    public String getBookWithPublisher(@PathVariable int id) {
        Publisher publisher = publisherService.findById(id);
        if (publisher == null) {
            return "Nie ma takiego wydawcy";
        }
        return bookService.getBooksWithPublisher(publisher).toString();
    }

    @RequestMapping("/all/author/{id}")
    @ResponseBody
    public String getBookWithAuthor(@PathVariable int id) {
        Author author = authorService.authorFindById(id);
        if (author == null) {
            return "Nie ma takiego autora";
        }
        return bookService.getBookWithAuthor(author).toString();
    }

    @RequestMapping("/title/{title}")
    @ResponseBody
    public String getBooksWithTitle(@PathVariable String title) {
        return bookService.getBooksWithTitle(title).toString();
    }

    @RequestMapping("/category/{category}")
    @ResponseBody
    public String getBooksWithCategory(@PathVariable Category category) {
        return bookService.getBookWithCategory(category).toString();
    }

    @RequestMapping("/categoryId/{id}")
    @ResponseBody
    public String getBooksWithCategoryId(@PathVariable Long id) {
        return bookService.getBooksWithCategoryId(id).toString();
    }
}