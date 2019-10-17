package com.samsolutions.validator.user;

import com.samsolutions.dto.form.UserFormDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserProfileValidator implements Validator {

    @Override
    public boolean supports(final Class<?> aClass) {
        return UserFormDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserFormDTO user = (UserFormDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "notEmpty");
        if (user.getName().length() < 2 || user.getName().length() > 32) {
            errors.rejectValue("name", "size.userForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "notEmpty");
        if (user.getSurname().length() < 2 || user.getSurname().length() > 32) {
            errors.rejectValue("surname", "size.userForm.surname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birth", "notEmpty");

        if (user.getTelephone().length() == 0) {
            errors.rejectValue("telephone", "size.userForm.telephone");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "patronymic", "notEmpty");
        if (user.getSurname().length() < 2 || user.getPassword().length() > 32) {
            errors.rejectValue("patronymic", "size.userForm.patronymic");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "notEmpty");
    }
}
