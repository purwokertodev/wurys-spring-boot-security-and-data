package com.wury.boot.validator;

import com.wury.boot.form.CommentForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by WURI on 26/04/2016.
 */
@Component
public class CommentFormValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(CommentFormValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(CommentForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("VALIDATE COMMENT FORM");
        CommentForm form = (CommentForm) target;
        validateField(form, errors);

    }

    private void validateField(CommentForm form, Errors errors){
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commentatorName", "commentForm.commentatorName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commentContent", "commentForm.commentContent.required");
    }
}
