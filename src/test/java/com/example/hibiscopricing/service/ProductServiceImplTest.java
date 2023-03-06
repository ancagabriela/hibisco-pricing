package com.example.hibiscopricing.service;

import com.example.hibiscopricing.domain.Product;
import com.example.hibiscopricing.domain.ProductRequest;
import com.example.hibiscopricing.repository.ProductModel;
import com.example.hibiscopricing.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    public static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.now();
    public static final int BRAND_ID = 1;
    public static final int PRODUCT_ID = 35455;
    public static final String CURR = "EUR";
    public static final float PRICE = 35f;
    public static final int PRIORITY = 1;
    public static final int PRICE_LIST = 1;
    @InjectMocks
    private ProductServiceImpl service;
    @Mock
    private ProductRepository repository;

    @Test
    void givenProduct_thenReturnPricingInfo() {
        ProductModel productModel = new ProductModel(BRAND_ID, LOCAL_DATE_TIME, LOCAL_DATE_TIME, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR);
        when(repository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME, LOCAL_DATE_TIME)).thenReturn(List.of(productModel));

        Product product = service.pricingInfo(ProductRequest.builder()
                .brandId(BRAND_ID)
                .productId(PRODUCT_ID)
                .date(LOCAL_DATE_TIME)
                .build());

        assertAll(
                () -> assertEquals(BRAND_ID, product.brandId()),
                () -> assertEquals(PRODUCT_ID, product.productId())
        );
        verify(repository).findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(BRAND_ID, PRODUCT_ID, LOCAL_DATE_TIME, LOCAL_DATE_TIME);
    }
}