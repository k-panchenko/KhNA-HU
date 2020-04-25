package ua.kharkiv.khnadu.application;

import java.math.BigInteger;

public class Program {
    public static void main(String[] args) {
        var console = System.console();
        try {
            var n = Integer.parseInt(console.readLine("Input n: "));

            var result = factorialHavingLargeResult(n);
            System.out.printf("Result: %d\n", result);
        } catch (NullPointerException ex) {
            System.out.println("Couldn't use console inside IDE");
        } catch (NumberFormatException ex) {
            System.out.println("Couldn't read int value from input");
        } catch (ArithmeticException ex) {
            System.out.printf("%s\n", ex.getMessage());
        }
    }

    private static BigInteger factorialHavingLargeResult(int n) {
        if (n < 0) throw new ArithmeticException("Couldn't calculate factorial from negative number");
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
