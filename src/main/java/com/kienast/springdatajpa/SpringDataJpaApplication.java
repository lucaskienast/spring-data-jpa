package com.kienast.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    private void insertFourEmployees(EmployeeRepository repository) {
        repository.save(new Employee("Tom", "Thompson"));
        repository.save(new Employee("Jerry", "Jefferson"));
        repository.save(new Employee("Susan", "Simpson"));
        repository.save(new Employee("Lara", "van Lawson"));
        System.out.println("Inserted four employees into H2");
    }

    @Bean
    public CommandLineRunner run(EmployeeRepository repository) {
        return (args) -> {
            insertFourEmployees(repository);
            System.out.println(repository.findAll());
            System.out.println(repository.findEmployeeByLastNameContaining(" "));
        };
    }

}
