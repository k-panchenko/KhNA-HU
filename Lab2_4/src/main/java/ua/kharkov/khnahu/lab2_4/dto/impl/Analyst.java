/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_4.dto.impl;

import lombok.ToString;
import ua.kharkov.khnahu.lab2_4.dto.api.Worker;

/**
 *
 * @author student
 */
@ToString(callSuper = true)
public class Analyst extends Worker {

    public Analyst(String name, Double salaryPerDay) {
        super(name, salaryPerDay);
    }
    public Analyst(String name) {
        super(name, 100.0);
    }
}
