package com.example.hibiscopricing.controller;

import com.example.hibiscopricing.domain.Product;
import com.example.hibiscopricing.domain.ProductRequest;
import com.example.hibiscopricing.service.ProductService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/pricing/")
public class PricingController {
    @Autowired
    private final ProductService productService;

    @PostMapping("/price")
    public ResponseEntity<ProductResponseDto> getPrice(@RequestParam Integer brandId,
                                                       @RequestParam Integer productId,
                                                       @RequestParam
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {

        Product product = productService.pricingInfo(ProductRequest.builder()
                .productId(productId)
                .brandId(brandId)
                .date(date)
                .build());

        return ResponseEntity.ok(ProductResponseDto.builder()
                .productId(product.productId())
                .brandId(product.brandId())
                .priceList(product.priceList())
                .startDate(product.startDate())
                .endDate(product.endDate())
                .price(product.price())
                .build());
    }

    @Builder
    record ProductResponseDto(Integer productId, Integer brandId, Integer priceList, LocalDateTime startDate,
                              LocalDateTime endDate,
                              Float price) implements Serializable {
    }
}
