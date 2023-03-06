package com.example.hibiscopricing.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Product(Integer productId, Integer brandId, Integer priceList, Integer priority,
                      LocalDateTime startDate, LocalDateTime endDate, Float price) {
}
