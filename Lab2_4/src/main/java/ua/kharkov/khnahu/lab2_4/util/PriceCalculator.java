/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_4.util;

import lombok.experimental.UtilityClass;
import ua.kharkov.khnahu.lab2_4.dto.api.Worker;

/**
 *
 * @author student
 */
@UtilityClass
public class PriceCalculator {
    public Double calculate(Worker worker, Integer days) {
        return worker.getSalaryPerDay() * days;
    }
}
