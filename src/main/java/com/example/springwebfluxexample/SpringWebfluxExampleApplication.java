package com.example.springwebfluxexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableReactiveMongoAuditing
public class SpringWebfluxExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxExampleApplication.class, args);
    }

}
