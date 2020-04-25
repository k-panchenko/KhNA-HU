package ua.kharkiv.khnadu.application;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Console;

public class Program {
    /**
     * for run use java -jar target/Lab3_3-1.0-SNAPSHOT.jar
     * @param args
     */
    public static void main(String[] args) {
        try {
            var reader = new ConsoleIntegerReader(System.console());

            System.out.print("Input number: ");
            var result = reader.read();
            System.out.printf("Result: %d\n", result);
        } catch (NullPointerException ex) {
            System.out.println("Couldn't use console from IDE");
        } catch (NumberFormatException ex) {
            System.out.println("Couldn't read integer from input");
        }
    }
}

@RequiredArgsConstructor
class ConsoleIntegerReader {
    @NonNull
    private final Console console;

    int read() throws NumberFormatException {
        return Integer.parseInt(console.readLine());
    }
}
