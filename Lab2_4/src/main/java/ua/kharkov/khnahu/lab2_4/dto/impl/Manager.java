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
public class Manager extends Worker {

    public Manager(String name, Double salaryPerDay) {
        super(name, salaryPerDay);
    }
    
    public Manager(String name) {
        super(name, 80.0);
    }
}
