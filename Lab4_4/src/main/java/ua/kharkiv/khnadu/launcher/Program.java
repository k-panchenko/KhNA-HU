package ua.kharkiv.khnadu.launcher;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomUtils;
import ua.kharkiv.khnadu.dto.Book;
import ua.kharkiv.khnadu.util.BookGenerator;
import ua.kharkiv.khnadu.util.JsonUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Program {
    @SneakyThrows
    public static void main(String[] args) {
        var books = BookGenerator.generate(10);
        var json = JsonUtil.toJson(books);

        var fileName = "books.json";
        try (var writer = new FileWriter(fileName, false)) {
            writer.write(json);
        }

        json = Files.readString(Path.of(fileName));

        books = JsonUtil.fromJson(json, Book[].class);

        var index = RandomUtils.nextInt(0, books.length);
        var author = books[index].getAuthor();

        System.out.printf("Filtered by author: %s\n", author);

        books = Arrays.stream(books)
                .filter(book -> book.getAuthor().equals(author))
                .toArray(Book[]::new);

        for (var book : books) {
            System.out.println(book);
        }
    }
}
