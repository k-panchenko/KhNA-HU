/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_4.dto.api;

import lombok.Data;

/**
 *
 * @author student
 */
@Data
public abstract class Worker {
    private final String name;
    private final Double salaryPerDay;
}
