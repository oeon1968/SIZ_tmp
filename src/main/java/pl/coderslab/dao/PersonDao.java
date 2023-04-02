package pl.coderslab.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.model.Person;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;

    public void savePerson(Person person){
        entityManager.persist(person);
    }

    public void editPerson(Person person){
        entityManager.merge(person);
    }

    public Person getPersonById(long id){
        return entityManager.find(Person.class, id);}

    public void delete(Person person){
        entityManager.remove(entityManager.contains(person)? person : entityManager.merge(person));
    }



}
