package com.graphql.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class GraphQlApplication implements CommandLineRunner {
    @Autowired
    ProduitRepository produitRepository;
    public static void main(String[] args) {
        SpringApplication.run(GraphQlApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Stream.of("iphone 5000","samsung 15000","honor 3000","infinix 2000").forEach(p->{
            String [] data = p.split(" ");
            Produit produit = new Produit(null,data[0],Double.valueOf(data[1]));
            produitRepository.save(produit);
        });
        produitRepository.findAll().forEach(p-> System.out.println(p));
    }
}
