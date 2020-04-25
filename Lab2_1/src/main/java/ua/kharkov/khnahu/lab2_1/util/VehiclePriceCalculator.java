/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_1.util;

import ua.kharkov.khnahu.lab2_1.dto.api.Vehicle;
import lombok.experimental.UtilityClass;

/**
 *
 * @author student
 */
@UtilityClass
public class VehiclePriceCalculator {
    public double calculate(Vehicle vehicle) {
        return vehicle.getPlaceCount() * vehicle.getPlacePrice();
    }
}
