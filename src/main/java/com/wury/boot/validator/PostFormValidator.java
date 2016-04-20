package com.wury.boot.validator;

import com.wury.boot.form.PostForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by WURI on 20/04/2016.
 */
@Component
public class PostFormValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(PostFormValidator.class);


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(PostForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("VALIDATE POST FORM");
        PostForm form = (PostForm) target;
        validateField(errors, form);
    }

    private void validateField(Errors errors, PostForm form){
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postTitle", "postForm.postTitle.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postContent", "postForm.postContent.required");
    }
}
