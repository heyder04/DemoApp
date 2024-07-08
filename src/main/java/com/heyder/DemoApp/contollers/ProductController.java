package com.heyder.DemoApp.contollers;

import com.heyder.DemoApp.model.Product;
import com.heyder.DemoApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
     return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestPart  Product prod, @RequestPart MultipartFile imageFile){
        System.out.println(prod);
       try {
           Product product1=service.addProduct(prod,imageFile);
           return new ResponseEntity<>(product1,HttpStatus.CREATED);
       }catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }



    @GetMapping("/products/{prodId}")
    public  ResponseEntity<Product> getProductById(@PathVariable int prodId ){
        Product product=service.getProductById(prodId);
        if (product!=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/products/{productId}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int productId){
        Product product=service.getProductById(productId);
        byte[] imageFile=product.getImageDate();
        return  ResponseEntity.ok().
                contentType(MediaType.valueOf(product.getImageType())).
                body(imageFile);
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart  Product prod, @RequestPart MultipartFile imageFile){
        Product product =service.getProductById(id);


        try {
            if (product!=null){
                service.updateProduct(id,prod,imageFile);
                return new ResponseEntity<>("Updated",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Not found",HttpStatus.BAD_GATEWAY);}

        }catch (IOException e){
            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
        }



    }

    @DeleteMapping ("/products/{prodId}")
    public ResponseEntity<String> deleteProductById(@PathVariable int prodId ){
      Product product =service.getProductById(prodId);
      if(product!=null){
          service.deleteById(prodId);
          return new ResponseEntity<>("Deleted",HttpStatus.OK);
      }else {
          return new ResponseEntity<>("Not found",HttpStatus.BAD_GATEWAY);
      }
    }

    @GetMapping("products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
        List<Product> product =service.searhProduct(keyword);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }


}
