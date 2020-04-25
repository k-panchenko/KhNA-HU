/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_2.application.util;

import lombok.experimental.UtilityClass;
import ua.kharkov.khnahu.lab2_2.dto.api.FreightCarrier;

/**
 *
 * @author student
 */
@UtilityClass
public class FreightCarrierPriceCalculator {
    public double calculate(FreightCarrier freightCarrier) {
        return freightCarrier.getCarryingCapacity() * freightCarrier.getFreightPrice();
    }
}
