package ua.kharkov.khadi.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ua.kharkov.khadi.service.PayrollCalculator;

import java.text.MessageFormat;

@ShellComponent
public class ShellPayrollCalculator {
    private final PayrollCalculator payrollCalculator;
    private final MessageFormat formatter = new MessageFormat("Your salary is: {0}");

    public ShellPayrollCalculator(PayrollCalculator payrollCalculator) {
        this.payrollCalculator = payrollCalculator;
    }

    @ShellMethod("Input your monthly salary")
    public String calculateByMonth(Double salary,
                            @ShellOption(defaultValue = "#{valueConfiguration.taxPercentage}")
                            Double taxPercentage) {
        return formatter.format(payrollCalculator.calculate(salary, taxPercentage));
    }

    @ShellMethod("Input your salary per hour, amount of hours per day and amount of days")
    public String calculateByHour(Double salaryPerHour,
                            Integer hours,
                            Integer days,
                            @ShellOption(defaultValue = "#{valueConfiguration.taxPercentage}")
                            Double taxPercentage) {
        return  formatter.format(payrollCalculator.calculate(salaryPerHour, hours, days, taxPercentage));
    }

    @ShellMethod("Input your salary per day and amount of days")
    public String calculateByDay(Double salaryPerDay,
                            Integer days,
                            @ShellOption(defaultValue = "#{valueConfiguration.taxPercentage}")
                            Double taxPercentage) {
        return formatter.format(payrollCalculator.calculate(salaryPerDay, days, taxPercentage));
    }
}
