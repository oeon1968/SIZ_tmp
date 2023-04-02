package pl.coderslab.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class BookDao {
//    zapis encji
@PersistenceContext
EntityManager entityManager;
    public void saveBook(Book book) {
        entityManager.persist(book);
    }

//    edycja encji
public void update(Book book) {
    entityManager.merge(book);
}

//    pobieranie po id

    public Book findById(long id) {

        return entityManager.find(Book.class, id);
    }
//    usuwanie po id
public void delete(Book book) {
    entityManager.remove(entityManager.contains(book) ?
            book : entityManager.merge(book)); }

    public Book findWithAuthorsById(long id) {
        Book book = findById(id);
        Hibernate.initialize(book.getAuthors());
        return entityManager.find(Book.class, id);
    }

    public List<Book> all() {
        return entityManager.createQuery("SELECT b FROM Book b").getResultList();
    }
    public List<Book> allWithAuthors() {
        return entityManager.createQuery("select distinct  b from Book b join fetch b.authors order by b.id").getResultList();
    }
    public List<Book> allWithRating(int rating) {
        Query query =entityManager.createQuery("select b from Book b where b.rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public List<Book> booksWithPublishers() {
        Query q = entityManager.createQuery("SELECT b FROM Book b JOIN b.publisher JOIN b.authors");
        return q.getResultList();
    }

    public List<Book> booksWithPublisher(Publisher publisher) {
        Query q = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher = :publisher");
        q.setParameter("publisher", publisher);
        return q.getResultList();
    }

    public List<Book> booksOfAuthor(Author author) {
        Query q = entityManager.createQuery("SELECT distinct b FROM Book b JOIN FETCH b.authors WHERE :author MEMBER OF b.authors");
        q.setParameter("author", author);
        return q.getResultList();
    }

    public List<Book> getBookWithAuthor(Author author) {
        Query query = entityManager.createQuery("select distinct b from Book b WHERE :author member of b.authors");
        query.setParameter("author", author);
        return query.getResultList();
    }
}
