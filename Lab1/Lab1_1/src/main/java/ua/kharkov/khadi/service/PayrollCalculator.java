package ua.kharkov.khadi.service;

import org.springframework.stereotype.Component;

@Component
public class PayrollCalculator {
    public Double calculate(Double salary, Double taxPercentage) {
        return salary * (100 - taxPercentage);
    }

    public Double calculate(Double salaryPerHour, Integer hours, Integer days, Double taxPercentage) {
        return  calculate(salaryPerHour * hours, days, taxPercentage);
    }

    public Double calculate(Double salaryPerDay, Integer days, Double taxPercentage) {
        return calculate(salaryPerDay * days, taxPercentage);
    }
}
