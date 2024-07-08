package com.heyder.DemoApp.services;

import com.heyder.DemoApp.model.Product;
import com.heyder.DemoApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;

    public List<Product> getProducts(){
       return repo.findAll();
    }
    public Product getProductById(int id){
     return repo.findById(id).orElse(null);
    };

    public Product addProduct(Product prod, MultipartFile imageFile) throws IOException {
        prod.setImageName(imageFile.getOriginalFilename());
        prod.setImageType(imageFile.getContentType());
        prod.setImageDate(imageFile.getBytes());
        return repo.save(prod);
    }

    public Product updateProduct(int id,Product prod,MultipartFile imageFile) throws IOException {
        prod.setImageName(imageFile.getOriginalFilename());
        prod.setImageType(imageFile.getContentType());
        prod.setImageDate(imageFile.getBytes());
       return repo.save(prod);



    }

    public void deleteById(int prodId) {
       repo.deleteById(prodId);
    }

    public List<Product> searhProduct(String keyword) {
      return    repo.searchProducts(keyword);
    }
}
