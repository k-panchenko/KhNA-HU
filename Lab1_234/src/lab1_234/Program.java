/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_234;

import static java.lang.Math.*;
/**
 *
 * @author student
 */
public class Program {

    /**
     * @param args - task number
     */
    public static void main(String[] args) {
        assert args.length > 0 : "Args haven't been entered";
        for (String arg : args) {
            switch (arg) {
                case "1": {
                    double a = 0.7;
                    double b = 0.05;
                    double x = 0.5;
                    System.out.printf("R = %s, s = %s\n", R(a, b, x), s(a, b, x));
                    break;
                }
                case "2": {
                    int m = 2;
                    int c = -1;
                    double t = 1.2;
                    double b = 0.7;
                    System.out.printf("f = %s, z = %s\n", f(m, c, t, b), z(m, c, t, b));
                    break;
                }
                case "3": {
                    double a = 3.2;
                    double b = 17.5;
                    double x = -4.8;
                    System.out.printf("y = %s, d = %s\n", y(a, b, x), d(a, b, x));
                    break;
                }
                default:
                    throw new AssertionError();
            }
        }
    }
    
    private static double R(double a, double b, double x) {
        return pow(x, 2) * (x + 1) / b - pow(sin(x + a), 2);
    }
    
    private static double s(double a, double b, double x) {
        return sqrt(x * b / a) + pow(cos(x + b), 2);
    }
    
    private static double f(int m, int c, double t, double b) {
        return pow(m * tan(t) + abs(c * sin(t)), 1/3.0);
    }
    
    private static double z(double m, double c, double t, double b) {
        return m * cos(b * t * sin(t)) + c;
    }
    
    private static double y(double a, double b, double x) {
        return b * pow(tan(x), 2) - a / pow(sin(x / a), 2);
    }
    
    private static double d(double a, double b, double x) {
        return a * exp(-sqrt(a)) * cos(b * x / a);
    }
}
