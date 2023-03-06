package com.example.hibiscopricing.service;

import com.example.hibiscopricing.domain.Product;
import com.example.hibiscopricing.domain.ProductRequest;

public interface ProductService {
    Product pricingInfo(ProductRequest product);
}
