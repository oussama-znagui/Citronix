package ma.znagui.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ma.znagui.app.validation.api.CheckDatePattern;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CheckDatePatternValidator implements ConstraintValidator<CheckDatePattern, LocalDate> {

    private static final String DATE_PATTERN = "MM/dd/yyyy";


    public boolean isValid(LocalDate customDateField,
                           ConstraintValidatorContext cxt) {
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
//        try
//        {
//            sdf.setLenient(false);
//            Date d = sdf.parse();
//            return true;
//        }
//        catch (ParseException e)
//        {
//            return false;
//        }
        return false;
    }
}
