package pl.coderslab.model;


import lombok.Data;
import java.util.List;


@Data
public class Student {
    String firstName;
    String lastName;
    String gender;
    String country;
    String notes;
    boolean mailingList;
    List<String> programmingSkills;
    List<String> hobbies;

}
