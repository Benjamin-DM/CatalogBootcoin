package com.bootcamp.calatologcurrencyservice.service;


import com.bootcamp.calatologcurrencyservice.model.CatalogEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICatalogCurrencyService {

     Flux<CatalogEntity> findAll();

     Mono<CatalogEntity> save(CatalogEntity client);

     Mono<CatalogEntity> create(CatalogEntity catalog);

     Mono<Void> delete(String id);

     Mono<CatalogEntity> update(CatalogEntity catalog);

     Mono<CatalogEntity> findById(String id);

}
