package pl.coderslab.validator;

import pl.coderslab.annotation.finishDateAfterStartAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Date;

public class finishDateAfterStartValidator implements ConstraintValidator<finishDateAfterStartAnnotation, Date> {
    @Override
    public void initialize(finishDateAfterStartAnnotation constraintAnnotation) {
    }

    @Override
    public boolean isValid(Date myDate, ConstraintValidatorContext context) {
        if (myDate == null) {
            return true;
        }
        return (myDate.after(Date.valueOf("2024-01-01")));
    }
}
