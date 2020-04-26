package ua.kharkiv.khnadu.validation;

import ua.kharkiv.khnadu.annotation.YearConstraint;
import ua.kharkiv.khnadu.dto.Book;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class YearConstraintValidator implements ConstraintValidator<YearConstraint, Integer> {

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
        return year >= 868 && year < Calendar.getInstance().get(Calendar.YEAR);
    }
}
