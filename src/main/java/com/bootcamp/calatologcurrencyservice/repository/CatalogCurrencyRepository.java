package com.bootcamp.calatologcurrencyservice.repository;

import com.bootcamp.calatologcurrencyservice.model.CatalogEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogCurrencyRepository extends ReactiveMongoRepository<CatalogEntity, String> {

   // Mono<CatalogCurrency> findByPhoneNumber(String phoneNumber);

}