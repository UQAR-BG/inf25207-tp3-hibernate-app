package com.inf25207.tp3.config;

import com.inf25207.tp3.domain.models.*;
import com.inf25207.tp3.repositories.interfaces.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.Date;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
            ITypeRepository typeRepo,
            IAdresseRepository adresseRepo,
            IEmployeRepository employeRepo,
            IAvionRepository avionRepo,
            IPiloteRepository piloteRepo,
            ITechnicienRepository techRepo,
            ISpecialisationRepository specialisationRepo,
            IReparationRepository reparationRepo,
            IQualificationRepository qualificationRepo) {
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

        Avion avion1 = new Avion();
        avion1.setType(type1);

        Avion avion2 = new Avion();
        avion2.setType(type2);

        Avion avion3 = new Avion();
        avion3.setType(type3);

        Avion avion4 = new Avion();
        avion4.setType(type2);

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

        Pilote pilote = new Pilote();
        pilote.setEmploye(employe1);

        Technicien technicien = new Technicien();
        technicien.setEmploye(employe2);

        Specialisation specialisation1 = new Specialisation();
        specialisation1.setTechnicien(technicien);
        specialisation1.setType(type1);

        Specialisation specialisation2 = new Specialisation();
        specialisation2.setTechnicien(technicien);
        specialisation2.setType(type3);

        Qualification qualification = new Qualification();
        qualification.setPilote(pilote);
        qualification.setType(type2);

        Reparation reparation1 = new Reparation();
        reparation1.setTechnicien(technicien);
        reparation1.setAvion(avion4);
        reparation1.setDate(new Date(2022, Calendar.DECEMBER, 1));
        reparation1.setCoutTotal(10000.00);

        Reparation reparation2 = new Reparation();
        reparation2.setTechnicien(technicien);
        reparation2.setAvion(avion2);
        reparation2.setDate(new Date(2022, Calendar.NOVEMBER, 27));
        reparation2.setCoutTotal(2500.00);

        return args -> {
            log.info("Preloading Type " + type1 + ", Success:  " + typeRepo.addType(type1));
            log.info("Preloading Type " + type2 + ", Success:  " + typeRepo.addType(type2));
            log.info("Preloading Type " + type3 + ", Success:  " + typeRepo.addType(type3));
            log.info("Preloading Avion " + avion1 + ", Success:  " + avionRepo.addAvion(avion1));
            log.info("Preloading Avion " + avion2 + ", Success:  " + avionRepo.addAvion(avion2));
            log.info("Preloading Avion " + avion3 + ", Success:  " + avionRepo.addAvion(avion3));
            log.info("Preloading Avion " + avion4 + ", Success:  " + avionRepo.addAvion(avion4));
            log.info("Preloading Adresse " + adresse1 + ", Success:  " + adresseRepo.addAdresse(adresse1));
            log.info("Preloading Adresse " + adresse2 + ", Success:  " + adresseRepo.addAdresse(adresse2));
            log.info("Preloading Employe " + employe1 + ", Success:  " + employeRepo.addEmploye(employe1));
            log.info("Preloading Employe " + employe2 + ", Success:  " + employeRepo.addEmploye(employe2));
            log.info("Preloading Pilote " + pilote + ", Success:  " + piloteRepo.addPilote(pilote));
            log.info("Preloading Technicien " + technicien + ", Success:  " + techRepo.addTechnicien(technicien));
            log.info("Preloading Specialisation " + specialisation1 + ", Success:  " + specialisationRepo.addSpecialisation(specialisation1));
            log.info("Preloading Specialisation " + specialisation2 + ", Success:  " + specialisationRepo.addSpecialisation(specialisation2));
            log.info("Preloading Qualification " + qualification + ", Success:  " + qualificationRepo.addQualification(qualification));
            log.info("Preloading Reparation " + reparation1 + ", Success:  " + reparationRepo.addReparation(reparation1));
            log.info("Preloading Reparation " + reparation2 + ", Success:  " + reparationRepo.addReparation(reparation2));
        };
    }
}