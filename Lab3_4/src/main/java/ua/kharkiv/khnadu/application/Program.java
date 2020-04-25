package ua.kharkiv.khnadu.application;

public class Program {
    public static void main(String[] args) {
        try {
            var console = System.console();

            var a = Double.parseDouble(console.readLine("Input a: "));
            var b = Double.parseDouble(console.readLine("Input b: "));
            var dx = Double.parseDouble(console.readLine("Input dx: "));
            var sum = 0d;
            System.out.printf("%20s | %20s\n", "x", "y");
            for (double x = a; x < b; x += dx) {
                var y = f(x);
                if (Double.isInfinite(y)) throw new ArithmeticException("Result if infinity");
                System.out.printf("%20f | %20f\n", x, y);
                sum += y;
            }
            System.out.printf("Sum: %f\n", sum);
        } catch (NullPointerException ex) {
            System.out.println("Couldn't use console from IDE");
        } catch (ArithmeticException ex) {
            System.out.printf("%s\n", ex.getMessage());
        }
    }

    private static double f(double x) {
        return Math.log(x - 1);
    }
}
