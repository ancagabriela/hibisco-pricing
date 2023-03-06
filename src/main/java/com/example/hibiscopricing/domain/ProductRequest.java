package com.example.hibiscopricing.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ProductRequest(Integer productId, Integer brandId, LocalDateTime date) {
}
