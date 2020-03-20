package de.coronavirus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronaVirusBackend {

    private final Logger log;

    public CoronaVirusBackend() {
        this.log = LoggerFactory.getLogger(CoronaVirusBackend.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CoronaVirusBackend.class, args);
    }
}
