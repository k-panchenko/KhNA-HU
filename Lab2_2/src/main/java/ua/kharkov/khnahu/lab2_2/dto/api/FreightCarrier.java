/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kharkov.khnahu.lab2_2.dto.api;

import lombok.Data;

/**
 *
 * @author student
 */
@Data
public abstract class FreightCarrier {
    protected double carryingCapacity;
    protected double freightPrice;
}
