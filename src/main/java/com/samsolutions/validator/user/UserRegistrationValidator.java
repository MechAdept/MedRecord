package com.samsolutions.validator.user;

import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserRegistrationValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(final Class<?> aClass) {
        return UserFormDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserFormDTO user = (UserFormDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "notEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "notEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "diff.userForm.passwordConfirm");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "notEmpty");
        if (user.getSurname().length() < 2 || user.getPassword().length() > 32) {
            errors.rejectValue("surname", "size.userForm.surname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "notEmpty");
        if (user.getSurname().length() < 2 || user.getPassword().length() > 32) {
            errors.rejectValue("name", "size.userForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "patronymic", "notEmpty");
        if (user.getSurname().length() < 2 || user.getPassword().length() > 32) {
            errors.rejectValue("patronymic", "size.userForm.patronymic");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birth", "notEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephone", "notEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "notEmpty");

        if (user.getTelephone().length() < 17 && user.getTelephone().length() > 0) {
            errors.rejectValue("telephone", "size.userForm.telephone");
        }
    }
}
