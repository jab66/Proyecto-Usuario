package com.example.usuario.validators;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = ContentWithoutSpacesValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContentWithoutSpaces {

    String message() default "{content.without.spaces}";
    Class<?>[] groups() default  {};
    Class<? extends Payload>[] payload() default {};

}
