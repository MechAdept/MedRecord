package com.samsolutions.validator;

import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserEditValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(final Class<?> aClass) {
        return UserFormDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserFormDTO user = (UserFormDTO) o;

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32 && user.getPassword().length() > 1) {
            errors.rejectValue("password", "size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "diff.userForm.passwordConfirm");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "notEmpty");
        if (user.getSurname().length() < 2 || user.getPassword().length() > 32) {
            errors.rejectValue("surname", "size.userForm.surname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "notEmpty");
        if (user.getSurname().length() < 2 || user.getPassword().length() > 32) {
            errors.rejectValue("surname", "size.userForm.surname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "notEmpty");
        if (user.getSurname().length() < 2 || user.getPassword().length() > 32) {
            errors.rejectValue("name", "size.userForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birth", "notEmpty");
        if (user.getSurname().length() < 2 || user.getPassword().length() > 32) {
            errors.rejectValue("name", "size.userForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "notEmpty");

        if (user.getRolesId().length < 1) {
            errors.rejectValue("rolesId", "size.userForm.rolesId");
        }
    }
}
