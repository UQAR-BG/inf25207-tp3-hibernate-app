package com.inf25207.tp3.config;

import com.inf25207.tp3.domain.models.Type;
import com.inf25207.tp3.repositories.interfaces.ITypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ITypeRepository repository) {
        Type type = new Type();
        type.setRayonAction(14816.00);
        type.setCapacite(1500);
        type.setPoids(447696.00);
        type.setNom("Boeing 747-8 Intercontinental");

        return args -> {
            log.info("Preloading " + repository.addType(type));
        };
    }
}