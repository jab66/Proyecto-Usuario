package com.example.usuario.validators;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = NotStartWithNumberValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotStartWithNumber {

    String message() default "{not.start.with.number}";
    Class<?>[] groups() default  {};
    Class<? extends Payload>[] payload() default {};

}
