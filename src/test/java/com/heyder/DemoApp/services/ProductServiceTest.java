package com.heyder.DemoApp.services;

import com.heyder.DemoApp.model.Product;
import com.heyder.DemoApp.repository.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepo mockRepo;

    private ProductService productServiceUnderTest;

    @BeforeEach
    void setUp() {
        productServiceUnderTest = new ProductService();
        productServiceUnderTest.repo = mockRepo;
    }

    @Test
    void testGetProducts() {
        // Setup
        final Product product = new Product();
        product.setId(0);
        product.setName("name");
        product.setImageName("imageName");
        product.setImageType("imageType");
        product.setImageDate("content".getBytes());
        final List<Product> expectedResult = List.of(product);

        // Configure ProductRepo.findAll(...).
        final Product product1 = new Product();
        product1.setId(0);
        product1.setName("name");
        product1.setImageName("imageName");
        product1.setImageType("imageType");
        product1.setImageDate("content".getBytes());
        final List<Product> products = List.of(product1);
        when(mockRepo.findAll()).thenReturn(products);

        // Run the test
        final List<Product> result = productServiceUnderTest.getProducts();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }


}
