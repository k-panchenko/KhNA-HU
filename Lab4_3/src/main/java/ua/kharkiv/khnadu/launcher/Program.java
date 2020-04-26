package ua.kharkiv.khnadu.launcher;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        var readFileName = "F1";
        var writeFileName = "F2";
        try (var reader = new FileReader(readFileName);
             var writer = new FileWriter(writeFileName, false)) {
            var scanner = new Scanner(reader);

            var count = 0;
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();
                if (line.startsWith("A")) {
                    writer.write(line);
                    writer.write("\n");

                    count += line.trim().split(" ").length;
                }
            }

            System.out.printf("Count of words in %s: %d", writeFileName, count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
