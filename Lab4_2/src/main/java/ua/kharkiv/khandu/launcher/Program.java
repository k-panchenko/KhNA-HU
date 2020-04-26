package ua.kharkiv.khandu.launcher;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        var aFileName = "afile";
        var bFileName = "bfile";
        var cFileName = "cfile";
        var separator = " ";
        try (var aReader = new FileReader(aFileName);
             var bReader = new FileReader(bFileName);
             var cWriter = new FileWriter(cFileName, false)) {
            var aScanner = new Scanner(aReader);
            var bScanner = new Scanner(bReader);

            int aColumnCount;
            if (!aScanner.hasNextInt())
                throw new IllegalArgumentException("Afile does not starts with column count");
            aColumnCount = aScanner.nextInt();
            aScanner.nextLine();

            int bColumnCount;
            if (!bScanner.hasNextInt())
                throw new IllegalArgumentException("Afile does not starts with column count");
            bColumnCount = bScanner.nextInt();
            bScanner.nextLine();

            assert  aColumnCount == bColumnCount : String
                    .format("Column does not equals M1: %d | M2: %d", aColumnCount, bColumnCount);

            List<Double> aDoubles = new ArrayList<>();
            List<Double> bDoubles = new ArrayList<>();

            while (aScanner.hasNextLine()) {
                var line = aScanner.nextLine();
                var split = line.trim().split(separator);

                assert split.length == aColumnCount : String.format("Incorrect column count in line: %s", line);

                for (var string : split) {
                    aDoubles.add(Double.valueOf(string));
                }
            }
            while (bScanner.hasNextLine()) {
                var line = bScanner.nextLine();
                var split = line.trim().split(separator);

                assert split.length == bColumnCount : String.format("Incorrect column count in line: %s", line);

                for (var string : split) {
                    bDoubles.add(Double.parseDouble(string));
                }
            }

            assert aDoubles.size() == bDoubles.size() : "Incorrect elements size";

            cWriter.write(String.valueOf(aColumnCount));

            for (int i = 0; i < aDoubles.size(); i++) {
                if (i % aColumnCount == 0) cWriter.write("\n");
                var sum = aDoubles.get(i) + bDoubles.get(i);
                cWriter.write(String.valueOf(sum));
                cWriter.write(" ");
            }
        } catch (IOException e) {
            System.err.printf("%s", e.getMessage());
        }
    }
}
