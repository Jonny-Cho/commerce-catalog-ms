package com.commerce;

import com.commerce.jpa.CatalogEntity;
import com.commerce.jpa.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CatalogRepository catalogRepository;

    public List<CatalogEntity> getCatalogByAll() {
        return catalogRepository.findAll();
    }

}
