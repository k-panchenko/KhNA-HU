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

            var lineCount = 0;
            var charsCount = 0;
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();
                ++lineCount;
                if (lineCount >= 4) {
                    writer.write(line);
                    writer.write("\n");
                }

                if (!scanner.hasNextLine()) {
                    var split = line.trim().split("\\W++");
                    charsCount = split[split.length - 1].length();
                }
            }

            System.out.printf("Count of chars of last word in %s: %d", writeFileName, charsCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
