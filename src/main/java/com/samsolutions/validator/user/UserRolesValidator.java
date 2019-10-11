package com.samsolutions.validator.user;

import com.samsolutions.dto.form.UserFormDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserRolesValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserFormDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserFormDTO user = (UserFormDTO) o;

        if (user.getRolesId().length < 1) {
            errors.rejectValue("rolesId", "size.userForm.rolesId");
        }
    }
}
