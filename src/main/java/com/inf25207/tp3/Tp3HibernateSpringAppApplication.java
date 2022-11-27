package com.inf25207.tp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
@ComponentScan(basePackages = {
        "com.inf25207.tp3.controllers",
        "com.inf25207.tp3.domain.editors",
        "com.inf25207.tp3.services",
        "com.inf25207.tp3.repositories",
        "com.inf25207.tp3",
        "com.inf25207.tp3.config"
})
@EnableJpaRepositories(basePackages = "com.inf25207.tp3.config", entityManagerFactoryRef = "sessionFactory")
public class Tp3HibernateSpringAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(Tp3HibernateSpringAppApplication.class, args);
    }

}
