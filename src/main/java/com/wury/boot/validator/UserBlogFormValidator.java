package com.wury.boot.validator;

import com.wury.boot.form.UserBlogForm;
import com.wury.boot.service.api.UserBlogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by WURI on 08/04/2016.
 */
@Component
public class UserBlogFormValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(UserBlogFormValidator.class);
    @Autowired
    private UserBlogService userBlogService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserBlogForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating userBlogForm"+ target.toString());
        UserBlogForm form = (UserBlogForm) target;
        validateEmail(errors, form);
        validatePasswords(errors, form);
    }

    private void validatePasswords(Errors errors, UserBlogForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            LOGGER.debug("VALIDATING PASSWORD");
            errors.rejectValue("password","password.no_match", "Passwords do not match");
        }
    }

    private void validateEmail(Errors errors, UserBlogForm form) {
        if (userBlogService.findByEmail(form.getEmail()).isPresent()) {
            LOGGER.debug("VALIDATING EMAIL ");
            errors.rejectValue("email","email.exists", "User with this email already exists");
        }
    }


}
