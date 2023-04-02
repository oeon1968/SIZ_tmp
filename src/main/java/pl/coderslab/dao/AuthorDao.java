package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;
    //zapis
    public void authorSave(Author author) {
        entityManager.persist(author);

    }
    //update
    public void authorUpdate(Author author) {
        entityManager.merge(author);
    }

    //wybór
    public Author authorFindById(long id) {
       return entityManager.find(Author.class, id);
    }
    //usuwanie
    public void authorDelete(Author author) {
        entityManager.remove(
                entityManager.contains(author) ? author : entityManager.merge(author)
        );
    }

    public List<Author> authors() {
        Query q = entityManager.createQuery("SELECT a FROM Author a");
        return q.getResultList();
    }
}
