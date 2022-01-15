package com.commerce.vo;

import com.commerce.jpa.CatalogEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCatalog {
    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;
    private Date createdAt;

    public ResponseCatalog(final CatalogEntity en) {
        this.productId = en.getProductId();
        this.productName = en.getProductName();
        this.unitPrice = en.getUnitPrice();
        this.stock = en.getStock();
        this.createdAt = en.getCreatedAt();
    }

    public static List<ResponseCatalog> from(final List<CatalogEntity> catalogEntityList) {
        return catalogEntityList.stream()
            .map(ResponseCatalog::new)
            .collect(Collectors.toList());
    }
}
