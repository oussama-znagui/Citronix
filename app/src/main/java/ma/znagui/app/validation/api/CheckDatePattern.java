package ma.znagui.app.validation.api;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ma.znagui.app.validation.CheckDatePatternValidator;
import ma.znagui.app.validation.CheckExistingValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckDatePatternValidator.class)
public @interface CheckDatePattern {

    String message() default "Erreur de daate";


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
