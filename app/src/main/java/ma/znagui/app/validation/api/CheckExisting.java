package ma.znagui.app.validation.api;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ma.znagui.app.validation.CheckExistingValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckExistingValidator.class)
public @interface CheckExisting {
    String message() default "L'ID  n'existe pas";


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    Class<?> entityC();


}
