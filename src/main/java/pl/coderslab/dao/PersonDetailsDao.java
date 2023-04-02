package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Person;
import pl.coderslab.model.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save (PersonDetails pd) {
        entityManager.persist(pd);
    }

    public void update (PersonDetails pd) {
        entityManager.merge(pd);
    }

    public void delete (PersonDetails pd) {
        entityManager.remove(pd);
    }

    public PersonDetails getPersonDetailsById (long id) {
        return entityManager.find(PersonDetails.class, id);
    }
}
