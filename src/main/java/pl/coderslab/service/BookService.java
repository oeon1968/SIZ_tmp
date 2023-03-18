package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Book;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;

    public void save(Book book) {
        bookDao.save(book);
    }

    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(Book book) {
        bookDao.delete(book);
    }
}
