package com.samsolutions.validator;

import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for registration form.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.validator
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(final Class<?> aClass) {
        return UserFormDTO.class.equals(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors) {
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
    }
}