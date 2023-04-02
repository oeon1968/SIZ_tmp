package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.model.Person;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonDao personDao;

    public void savePerson(Person person){personDao.savePerson(person);}
    public void editPerson(Person person){personDao.editPerson(person);}
    public Person getPersonById(long id){return personDao.getPersonById(id);}
    public void delete(Person person){personDao.delete(person);}
}
