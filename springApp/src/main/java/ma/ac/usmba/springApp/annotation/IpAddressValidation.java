package ma.ac.usmba.springApp.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IpAddressValidation implements ConstraintValidator<IpAddress, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        Pattern pattern = Pattern.compile("([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})");
        Matcher matcher = pattern.matcher(s);
        try {
            if (!matcher.matches()) return false;
            else {
                for (int i = 1; i <= 4; i++) {
                    int v = Integer.parseInt(matcher.group(i));
                    if (v > 255) return false;
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
