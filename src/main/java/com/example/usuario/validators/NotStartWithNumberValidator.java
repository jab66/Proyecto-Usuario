package com.example.usuario.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotStartWithNumberValidator implements ConstraintValidator<NotStartWithNumber, String> {

    @Override
    public void initialize(NotStartWithNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.length()>0){
            if (s.length()>0 && s.substring(0,1).chars().allMatch(Character::isDigit)) {
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }
}
