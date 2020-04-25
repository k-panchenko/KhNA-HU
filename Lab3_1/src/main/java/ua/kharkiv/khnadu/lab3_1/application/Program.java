package ua.kharkiv.khnadu.lab3_1.application;

public class Program {
    public static void main(String[] args) {
        var console = System.console();
        try {
            System.out.println("Input a: ");
            var a = Double.parseDouble(console.readLine());
            System.out.println("Input b: ");
            var b = Double.parseDouble(console.readLine());
            System.out.println("Input c: ");
            var c = Double.parseDouble(console.readLine());

            var result = Math.sqrt(a - b) / c;
            if (Double.isNaN(result)) throw new ArithmeticException("Result is not a number");
            System.out.printf("Result: %.2f\n", result);
        } catch (NumberFormatException ex) {
            System.out.println("Couldn't parse double from input");
        } catch (ArithmeticException ex) {
            System.out.printf("Couldn't calculate result | %s\n", ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("Couldn't use console inside IDE");
        }
    }
}
