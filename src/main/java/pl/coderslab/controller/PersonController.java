package pl.coderslab.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Person;
import pl.coderslab.model.PersonDetails;
import pl.coderslab.service.PersonService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable long id){
        Person person = personService.getPersonById(id);
        personService.delete(person);
        return "Deleted";
    }

    @RequestMapping("/update/{id}/{login}")
    @ResponseBody
    public String updatePerson(@PathVariable long id, @PathVariable String login){
        Person person = personService.getPersonById(id);
        person.setLogin(login);
        personService.editPerson(person);
        return person.toString();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable long id){
        Person person = personService.getPersonById(id);
        return person.toString();
    }

    @RequestMapping("/add")
    @ResponseBody
    public String create(){
        LocalDateTime myTime = LocalDateTime.now();
        Person person = new Person();
        person.setEmail(myTime.toString()+"@mail.com");
        person.setPassword(myTime.toString()+"pswd");
        person.setLogin("robert"+myTime.getMinute()+"_"+myTime.getSecond());
        PersonDetails personDetails = new PersonDetails();
        personDetails.setCity("Bydgoszcz");
        personDetails.setStreet("ul "+myTime.getMinute()+"_"+myTime.getSecond());
        personDetails.setFirstName("Robert"+myTime.getMinute()+"_"+myTime.getSecond());
        personDetails.setLastName("Wolinski"+myTime.getMinute()+"_"+myTime.getSecond());
        personDetails.setStreetNumber(myTime.getMinute());
        person.setPersonDetails(personDetails);
        personService.savePerson(person);

        return "Id nowej persony to: " + person.getId();

    }

}
