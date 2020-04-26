package ua.kharkiv.khnadu.util;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import ua.kharkiv.khnadu.dto.Book;

import javax.validation.constraints.Min;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@UtilityClass
public class BookGenerator {
    private Faker faker = new Faker();

    public Book generate() {
        try {
            return new Book(
                    faker.book().author(),
                    faker.book().title(),
                    generateYear()
            );
        } catch (Exception ex) {
            return null;
        }
    }

    public Book[] generate(@Min(value = 1) Integer count) {
        return IntStream.range(0, count)
                .mapToObj(__ -> generate())
                .toArray(Book[]::new);
    }

    private Integer generateYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(faker.date().past(365 * 1000, TimeUnit.DAYS));
        return calendar.get(Calendar.YEAR);
    }
}
