/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_1.application;

import ua.kharkov.khnahu.lab2_1.dto.impl.Car;
import ua.kharkov.khnahu.lab2_1.dto.impl.Bus;
import ua.kharkov.khnahu.lab2_1.dto.impl.Taxi;
import ua.kharkov.khnahu.lab2_1.dto.api.Vehicle;
import java.util.ArrayList;
import java.util.List;
import ua.kharkov.khnahu.lab2_1.util.VehiclePriceCalculator;

/**
 *
 * @author student
 */
public class Program {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Taxi());
        vehicles.add(new Bus());
        
        vehicles.forEach(vehicle ->{
            System.out.printf("%s voyage sum is %s\n", 
                    vehicle.getClass().getSimpleName(),
                    VehiclePriceCalculator.calculate(vehicle));
    });
    }
}
