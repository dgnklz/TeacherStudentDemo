package com.dgnklz.studentteachertraining;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

}
