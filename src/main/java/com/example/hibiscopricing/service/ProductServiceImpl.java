package com.example.hibiscopricing.service;

import com.example.hibiscopricing.domain.Product;
import com.example.hibiscopricing.domain.ProductRequest;
import com.example.hibiscopricing.repository.ProductModel;
import com.example.hibiscopricing.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product pricingInfo(ProductRequest productRequest) {

        List<ProductModel> productModelList = productRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productRequest.brandId(), productRequest.productId(), productRequest.date(), productRequest.date());

        return Product.builder()
                .brandId(productModelList.get(0).getBrandId())
                .productId(productModelList.get(0).getProductId())
                .price(productModelList.get(0).getPrice())
                .startDate(productModelList.get(0).getStartDate())
                .endDate(productModelList.get(0).getEndDate())
                .priceList(productModelList.get(0).getPriceList())
                .build();
    }
}
