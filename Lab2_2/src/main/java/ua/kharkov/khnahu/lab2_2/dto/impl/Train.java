/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_2.dto.impl;

import ua.kharkov.khnahu.lab2_2.dto.api.FreightCarrier;

/**
 *
 * @author student
 */
public class Train extends FreightCarrier {

    public Train() {
        super.carryingCapacity = 20000;
        super.freightPrice = 500;
    }
    
}
