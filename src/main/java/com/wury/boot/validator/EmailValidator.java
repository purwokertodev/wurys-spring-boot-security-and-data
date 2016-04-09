package com.wury.boot.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;

/**
 * Created by WURI on 08/04/2016.
 */
@Pattern(regexp=".+@.+\\..+", message="{EmailValidator.email}")
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface EmailValidator {
    String message() default "{EmailValidator.email}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
