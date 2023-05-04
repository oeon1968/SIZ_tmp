package pl.coderslab.annotation;

import pl.coderslab.validator.finishDateAfterStartValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = finishDateAfterStartValidator.class)
public @interface finishDateAfterStartAnnotation {
    String message() default "{finishDateAfterStart.error.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
