package com.commerce.controller;

import com.commerce.CatalogService;
import com.commerce.jpa.CatalogEntity;
import com.commerce.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatalogController {
    private final Environment env;
    private final CatalogService catalogService;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Catalog Service on PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs() {
        final List<CatalogEntity> catalogEntityList = catalogService.getCatalogByAll();
        final List<ResponseCatalog> result = ResponseCatalog.from(catalogEntityList);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
