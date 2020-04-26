package ua.kharkiv.khnadu.annotation;

import ua.kharkiv.khnadu.validation.YearConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = YearConstraintValidator.class)
public @interface YearConstraint {
    String message() default "{value.negative}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
