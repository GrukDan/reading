package com.reading.services.impl;

import com.reading.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    ProductService productService = new ProductServiceImpl();

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllByType() {
    }

    @Test
    void getAllByPriceInBetween() {
    }

    @Test
    void getAllByTypeNameAndPriceInBetween() {
    }
}
