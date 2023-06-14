package com.example.graphqlwithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.graphqlwithspringboot.query", "com.example.graphqlwithspringboot.service",
        "com.example.graphqlwithspringboot.resolve", "com.example.graphqlwithspringboot.mutation"})
@EntityScan("com.example.graphqlwithspringboot.entity")
@EnableJpaRepositories("com.example.graphqlwithspringboot.repository")
public class GraphQlWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQlWithSpringBootApplication.class, args);
    }

}
