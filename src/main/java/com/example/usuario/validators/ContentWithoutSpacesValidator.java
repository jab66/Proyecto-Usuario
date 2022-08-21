package com.example.usuario.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContentWithoutSpacesValidator implements ConstraintValidator<ContentWithoutSpaces, String> {

    @Override
    public void initialize(ContentWithoutSpaces constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean space = s.matches(".*\\s+.*");
        if (space) {
            return false;
        }else{
            return true;
        }
    }
}
