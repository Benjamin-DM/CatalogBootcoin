package com.bootcamp.calatologcurrencyservice.controller;


import com.bootcamp.calatologcurrencyservice.model.CatalogEntity;
import com.bootcamp.calatologcurrencyservice.service.ICatalogCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalogcurrency")
public class CatalogCurrencyController {
    private final ICatalogCurrencyService service;

    @GetMapping
    public Flux<CatalogEntity> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<CatalogEntity> getOne(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<CatalogEntity> create(@RequestBody CatalogEntity product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Mono<CatalogEntity> update(CatalogEntity product) {
        return service.update(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
