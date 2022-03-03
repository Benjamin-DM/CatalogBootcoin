package com.bootcamp.calatologcurrencyservice.service;

import com.bootcamp.calatologcurrencyservice.model.CatalogEntity;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCacheEvict;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCachePut;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCacheable;
import com.hanqunfeng.reactive.redis.cache.aop.ReactiveRedisCaching;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CatalogServiceRed extends ICatalogCurrencyService{

    static String CACHE_NAME = "catalogs";

    @ReactiveRedisCacheable(cacheName = CACHE_NAME, key = "'findAll'")
    Flux<CatalogEntity> findAll();

    @ReactiveRedisCacheable(cacheName = CACHE_NAME, key = "'findById_' + #id")
    Mono<CatalogEntity> findById(String id);

    @ReactiveRedisCacheEvict(cacheName = CACHE_NAME, allEntries = true)
    Mono<CatalogEntity> create(CatalogEntity catalog);

    @ReactiveRedisCaching(
            evict = {@ReactiveRedisCacheEvict(cacheName = CACHE_NAME, key = "findAll"),},
            put = {
                    @ReactiveRedisCachePut(cacheName = CACHE_NAME, key = "'findById_' + #catalog.id"),
            }
    )
    Mono<CatalogEntity> update(CatalogEntity catalog);

    @ReactiveRedisCacheEvict(cacheName = CACHE_NAME, key = "'findById_' + #id")
    Mono<Void> delete(String id);
}
