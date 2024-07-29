package com.heyder.DemoApp.repository;

import com.heyder.DemoApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT p from Product p WHERE "+
    "LOWER(p.name) like lower(concat('%', :keyword,'%' )) OR "+
    "LOWER(p.description) like lower(concat('%', :keyword,'%' )) OR "+
    "LOWER(p.brand) like lower(concat('%', :keyword,'%' )) OR "+
    "LOWER(p.category) like lower(concat('%', :keyword,'%' )) "
    )     //query method,native query,
    List<Product> searchProducts(String keyword);
}
