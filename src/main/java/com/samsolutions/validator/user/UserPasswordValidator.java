package com.samsolutions.validator.user;

import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserPasswordValidator implements Validator {

    @Override
    public boolean supports(final Class<?> aClass) {
        return UserFormDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserFormDTO user = (UserFormDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "notEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "diff.userForm.passwordConfirm");
        }
    }
}
