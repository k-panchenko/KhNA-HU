/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_3.application;

import com.github.javafaker.Faker;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ua.kharkov.khnahu.lab2_3.dto.api.Learner;
import ua.kharkov.khnahu.lab2_3.dto.impl.SchoolBoy;
import ua.kharkov.khnahu.lab2_3.dto.impl.Student;

/**
 *
 * @author student
 */
public class Program {
    public static void main(String[] args) {
        var subjects = Arrays.asList(
                "Украинский язык", 
                "Украинская литература", 
                "Английский язык", 
                "Зарубежная литература",
                "История Украины", 
                "Всемирная история", 
                "Основы правоведения", 
                "Искусство", 
                "Алгебра" ,
                "Геометрия",
                "Биология",
                "География",
                "Физика",
                "Химия",
                "Трудовое обучение",
                "Информатика",
                "Основы здоровья",
                "Физическая культура",
                "Польский язык"
        );
        var random = new Random();
        var students = IntStream.rangeClosed(1, 
                random.nextInt(20 - 1 + 1) + 1)
                .mapToObj(__ -> {
                    String name = new Faker().name().fullName();
                    return random.nextBoolean() 
                            ? new SchoolBoy(name)
                            : new Student(name);
                     }
                )
                .collect(Collectors.toList());
        var table = HashBasedTable.<String, Learner, Integer>create();
        for (int i = 0; i < students.size() * subjects.size(); i++) {
           table.put(
                    subjects.get(random.nextInt(subjects.size())), 
                    students.get(random.nextInt(students.size())),
                    random.nextInt(12 - 2 + 1) + 2 
            );
        }
        System.out.print("\t\t\t");
        for (var subject : subjects) {
            System.out.printf("%25s", subject);
        }
        System.out.printf("%25s\n", "Средний балл");
        for (var student : students) {
            System.out.printf("%-20s", student.getName());
            for (var subject : subjects) {
                var value = table.get(subject, student);
                System.out.printf("%25s", value == null 
                        ? "-" 
                        : value);
            }
            System.out.printf("%25.2f\n",
                    table.column(student).values().stream()
                            .filter(Objects::nonNull)
                            .mapToInt(__ -> __)
                            .average()
                            .orElse(0.0));
        }
    }
}
