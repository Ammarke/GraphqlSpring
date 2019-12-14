package com.graphql.demo;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    ProduitRepository produitRepository;

    public Produit getProduit(Integer id){
        return produitRepository.findById(id).get();
    }
    public List<Produit> getAll(){
        return produitRepository.findAll();
    }
}
