package de.coronavirus;

import de.coronavirus.application.util.SampleDataImporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronaVirusBackend {

    private final Logger log;

    public SampleDataImporter sampleDataImporter;

    @Autowired
    public CoronaVirusBackend(SampleDataImporter sampleDataImporter) {
        this.sampleDataImporter = sampleDataImporter;
        this.log = LoggerFactory.getLogger(CoronaVirusBackend.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CoronaVirusBackend.class, args);
    }

    @Configuration
    @Profile({"default", "postgres"})
    class ProductionConfig implements InitializingBean {

        @Override
        public void afterPropertiesSet() {
            log.info("Resetting Database to sample data");
            sampleDataImporter.resetToSampleData();
            log.info("Done");
        }
    }
}
