package com.inf25207.tp3.config;

import com.inf25207.tp3.domain.models.Adresse;
import com.inf25207.tp3.domain.models.Employe;
import com.inf25207.tp3.domain.models.Type;
import com.inf25207.tp3.repositories.interfaces.IAdresseRepository;
import com.inf25207.tp3.repositories.interfaces.IEmployeRepository;
import com.inf25207.tp3.repositories.interfaces.ITypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ITypeRepository typeRepo, IAdresseRepository adresseRepo, IEmployeRepository employeRepo) {
        Type type1 = new Type();
        type1.setRayonAction(14816.00);
        type1.setCapacite(1500);
        type1.setPoids(447696.00);
        type1.setNom("Boeing 747-8 Intercontinental");

        Type type2 = new Type();
        type2.setRayonAction(16112.00);
        type2.setCapacite(762);
        type2.setPoids(316000.00);
        type2.setNom("Airbus A350-1000");

        Type type3 = new Type();
        type3.setRayonAction(14816.00);
        type3.setCapacite(1750);
        type3.setPoids(575000.00);
        type3.setNom("Airbus A380-800");

        Adresse adresse1 = new Adresse();
        adresse1.setNumeroRue(1275);
        adresse1.setNomRue("Rue de Fontenay");
        adresse1.setVille("Québec");
        adresse1.setCodePostal("dscbadkwidsjhcsab");
        adresse1.setProvince("Québec");
        adresse1.setPays("Canada");

        Adresse adresse2 = new Adresse();
        adresse2.setNumeroRue(5);
        adresse2.setNomRue("Rue Langlois");
        adresse2.setVille("Lévis");
        adresse2.setCodePostal("G6V2N4");
        adresse2.setProvince("Québec");
        adresse2.setPays("Canada");

        Employe employe1 = new Employe();
        employe1.setPrenom("Bastien");
        employe1.setNom("Goulet");
        employe1.setAdresse(adresse2);
        employe1.setTelephone("418-418-4884");
        employe1.setDateEngagement(new Date());
        employe1.setSalaire(70000.00);

        Employe employe2 = new Employe();
        employe2.setPrenom("Martin");
        employe2.setNom("Pouliot");
        employe2.setAdresse(adresse1);
        employe2.setTelephone("581-418-8448");
        employe2.setDateEngagement(new Date());
        employe2.setSalaire(55000.00);

        return args -> {
            log.info("Preloading Type " + type1 + ", Success:  " + typeRepo.addType(type1));
            log.info("Preloading Type " + type2 + ", Success:  " + typeRepo.addType(type2));
            log.info("Preloading Type " + type3 + ", Success:  " + typeRepo.addType(type3));
            log.info("Preloading Adresse " + adresse1 + ", Success:  " + adresseRepo.addAdresse(adresse1));
            log.info("Preloading Adresse " + adresse2 + ", Success:  " + adresseRepo.addAdresse(adresse2));
            log.info("Preloading Employe " + employe1 + ", Success:  " + employeRepo.addEmploye(employe1));
            log.info("Preloading Employe " + employe2 + ", Success:  " + employeRepo.addEmploye(employe2));
        };
    }
}