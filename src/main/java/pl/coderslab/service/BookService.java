package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.BookRepository;

import java.util.List;


@Service
@RequiredArgsConstructor

public class BookService {

    private final BookDao bookDao;
    private final BookRepository bookRepository;
    //    zapis encji

    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    //    edycja encji
    public void update(Book book) {
        bookDao.update(book);
    }

//    pobieranie po id

    public Book findById(long id) {
        return bookDao.findById(id);

    }
    public Book findWithAuthorsById(long id) {
        return bookDao.findWithAuthorsById(id);
    }

    //    usuwanie po id
    public void delete(Book book) {
        bookDao.delete(book);
    }

    public List<Book> all() {
       return  bookDao.all();
    }

    public List<Book> allWithAuthors() {
        return bookDao.allWithAuthors();
    }

    public List<Book> allWithRating(int rating) {
        return bookDao.allWithRating(rating);
    }

    public List<Book> getBooksWithPublisher(Publisher publisher){
        return bookDao.booksWithPublisher(publisher);
    }

    public List<Book> booksWithPublishers(){
        return bookDao.booksWithPublishers();
    }

    public List<Book> booksOfAuthor(Author author) {
        return bookDao.booksOfAuthor(author);
    }
    public List<Book> getBookWithAuthor(Author author) {
        return bookDao.getBookWithAuthor(author);
    }
    @javax.transaction.Transactional
    public List<Book> getBooksWithTitle(String title) {
       // List<Book> books = bookRepository.readBooksByTitle(title);
        List<Book> books = bookRepository.findBooksByTitle(title);
        getAuthorsToBookList(books);
        return books;
    }

    @javax.transaction.Transactional
    public List<Book> getBookWithCategory(Category category) {
        //List<Book> books = bookRepository.readBooksByCategory(category);
        List<Book> books = bookRepository.findBookByCategory(category);
        getAuthorsToBookList(books);
        return books;
    }

    @javax.transaction.Transactional
    public List<Book> getBooksWithCategoryId(Long id) {
        List<Book> books = bookRepository.readBooksByCategoryId(id);
        getAuthorsToBookList(books);
        return books;
    }

    //wyciągnąłem z powyższy metod współny tekst
    private void getAuthorsToBookList(List<Book> books) {
        books.stream()
                .forEach(b -> Hibernate.initialize(b.getAuthors()));
    }
}
