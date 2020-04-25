/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_2.application.Program;

import java.util.ArrayList;
import java.util.List;
import ua.kharkov.khnahu.lab2_2.application.util.FreightCarrierPriceCalculator;
import ua.kharkov.khnahu.lab2_2.dto.api.FreightCarrier;
import ua.kharkov.khnahu.lab2_2.dto.impl.Airplane;
import ua.kharkov.khnahu.lab2_2.dto.impl.Car;
import ua.kharkov.khnahu.lab2_2.dto.impl.Train;

/**
 *
 * @author student
 */
public class Program {
    public static void main(String[] args) {
        List<FreightCarrier> freightCarriers = new ArrayList<>();
        freightCarriers.add(new Airplane());
        freightCarriers.add(new Car());
        freightCarriers.add(new Train());
        
        freightCarriers.forEach(freightCarrier -> {
            System.out.printf("%s voyage sum is %s",
                    freightCarrier.getClass().getSimpleName(),
                    FreightCarrierPriceCalculator.calculate(freightCarrier));
        });
    }
}
