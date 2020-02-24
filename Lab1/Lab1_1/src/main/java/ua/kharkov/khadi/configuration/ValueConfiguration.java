package ua.kharkov.khadi.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Getter
@Configuration
@PropertySource("application.properties")
public class ValueConfiguration {
    @Value("${taxPercentage}")
    private Double taxPercentage;
}

