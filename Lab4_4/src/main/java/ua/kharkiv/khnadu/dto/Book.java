package ua.kharkiv.khnadu.dto;

import lombok.Value;
import ua.kharkiv.khnadu.annotation.YearConstraint;

import javax.validation.constraints.Size;

@Value
public class Book {
    @Size(min = 1)
    private String author;
    @Size(min = 1)
    private String title;
    @YearConstraint
    private Integer yearOfPublishing;
}
