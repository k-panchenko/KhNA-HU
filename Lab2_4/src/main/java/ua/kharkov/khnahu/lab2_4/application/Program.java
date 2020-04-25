/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_4.application;

import com.github.javafaker.Faker;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;
import ua.kharkov.khnahu.lab2_4.dto.api.Worker;
import ua.kharkov.khnahu.lab2_4.dto.impl.*;
import ua.kharkov.khnahu.lab2_4.util.PriceCalculator;

/**
 *
 * @author student
 */
public class Program {
    public static void main(String[] args) {
        var report = new HashMap<Worker, Integer>();
        var random = new Random();
        IntStream.rangeClosed(10, random.nextInt(60 - 10 + 1) + 10)
                .forEach(__ -> {
                    Worker worker;
                    String fullName = new Faker().name().fullName();
                    switch (random.nextInt(5)) {
                        case 0: 
                            worker = new Analyst(fullName);
                            break;
                        case 1:
                            worker = new Designer(fullName);
                            break;
                        case 2:
                            worker = new Manager(fullName);
                            break;
                        case 3: 
                            worker = new Programmer(fullName);
                            break;
                        case 4:
                            worker = new Tester(fullName);
                            break;
                        default:
                            throw new RuntimeException();
                    }
                    var days = random.nextInt(31 - 0 + 1) + 0;
                    report.put(worker, days);
                });
        for (var worker : report.keySet()) {
            var days =  report.get(worker);
            System.out.printf("%s | Days: %d | Salary: %.2f\n", 
                    worker,
                    days,
                    PriceCalculator.calculate(worker, days));
        }           
    }
}
