package ua.kharkiv.khnadu.launcher;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class Program {
    public static void main(String[] args) {
        try {
            var origin = parseInt(args[0]);
            var bound = parseInt(args[1]);

            assert origin < bound : "Origin is greater than bound";

            var fileName = args[2];
            assert  !isEmpty(fileName) : "File name is empty";

            var count = bound - origin + 1;

            var ints = new Random().ints(count,1, 10)
                    .distinct()
                    .toArray();

            var file = new File(fileName);
            assert !file.isDirectory() : "File name is directory";

            if (!file.exists() && !file.createNewFile())
                throw new IOException("Could not create file");

            try (var writer = new FileWriter(file, false)) {
                for (var number : ints) {
                    writer.write(String.valueOf(number));
                    writer.write(" ");
                }
                writer.flush();
            }

            try (var reader = new FileReader(file)) {
                int c;
                while((c=reader.read())!=-1){
                    System.out.print((char)c);
                }
            }
        } catch (NumberFormatException ex) {
            System.out.printf("%s must be int\n", ex.getMessage());
            exit(1);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Arguments: 1 - origin,  2 - bound, 3 - file name");
            exit(1);
        } catch (IOException e) {
            System.out.printf("%s", e.getMessage());
        }
    }
}
