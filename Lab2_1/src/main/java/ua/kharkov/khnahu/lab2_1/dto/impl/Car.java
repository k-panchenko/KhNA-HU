/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_1.dto.impl;

import ua.kharkov.khnahu.lab2_1.dto.api.Vehicle;

/**
 *
 * @author student
 */
public class Car extends Vehicle {

    public Car() {
        super.placeCount = 4;
        super.placePrice = 100.0;
    }
}
