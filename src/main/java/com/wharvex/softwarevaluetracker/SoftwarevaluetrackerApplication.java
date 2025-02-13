package com.wharvex.softwarevaluetracker;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoftwarevaluetrackerApplication {

    private static final Logger log = LoggerFactory.getLogger(SoftwarevaluetrackerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SoftwarevaluetrackerApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(AppRepository repository) {
        return (args) -> {
            // Get all apps from APP table.
            var allApps = new ArrayList<>();
            repository.findAll().forEach(allApps::add);

            // Populate APP table if empty.
            if (allApps.isEmpty()) {
                repository.save(new App("TerminalNewsReader"));
                repository.save(new App("Armoire"));
            }

            // Reset allApps.
            allApps = new ArrayList<>();
            repository.findAll().forEach(allApps::add);

            // Log apps.
            log.info("Apps found with findAll():");
            log.info("-------------------------------");
            allApps.forEach(app -> {
                log.info(app.toString());
            });
            log.info("");

            // Fetch an app by ID.
            var firstApp = repository.findById(1);
            log.info("App found with findById(1):");
            log.info("--------------------------------");
            log.info(firstApp != null ? firstApp.toString() : "not found");
            log.info("");

            // Fetch an app by name.
            log.info("App found with findByAppName('Armoire'):");
            log.info("--------------------------------------------");
            repository.findByAppName("Armoire").forEach(armoire -> {
                log.info(armoire != null ? armoire.toString() : "not found");
            });
            log.info("");
        };
    }

}
