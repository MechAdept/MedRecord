package com.samsolutions.validator.health;

import com.samsolutions.dto.form.HealthFormDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class HealthValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return HealthFormDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        HealthFormDTO healthFormDTO = (HealthFormDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "height", "notEmpty");
        if (!healthFormDTO.getHeight().isEmpty()) {
            if (Long.parseLong(healthFormDTO.getHeight()) < 0) {
                errors.rejectValue("height", "health.errors.height.negative");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weight", "notEmpty");
        if (!healthFormDTO.getWeight().isEmpty()) {
            if (Long.parseLong(healthFormDTO.getWeight()) < 0) {
                errors.rejectValue("weight", "health.errors.weight.negative");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "chest", "notEmpty");
        if (!healthFormDTO.getChest().isEmpty()) {
            if (Long.parseLong(healthFormDTO.getChest()) < 0) {
                errors.rejectValue("chest", "health.errors.chest.negative");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "waist", "notEmpty");
        if (!healthFormDTO.getWaist().isEmpty()) {
            if (Long.parseLong(healthFormDTO.getWaist()) < 0) {
                errors.rejectValue("waist", "health.errors.waist.negative");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hips", "notEmpty");
        if (!healthFormDTO.getHips().isEmpty()) {
            if (Long.parseLong(healthFormDTO.getHips()) < 0) {
                errors.rejectValue("hips", "health.errors.hips.negative");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nervous", "notEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "constitution", "notEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "musculature", "notEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "blood", "notEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "drugs", "notEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "alcohol", "notEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "smoke", "notEmpty");
    }
}
