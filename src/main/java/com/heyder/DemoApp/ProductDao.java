package com.heyder.DemoApp;

import com.heyder.DemoApp.model.Product;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    EntityManager en;
    @SuppressWarnings("unchecked")
    public List<Product> getProducts(){
        return en.createNamedStoredProcedureQuery("firstProcedure").getResultList();
    }
}
