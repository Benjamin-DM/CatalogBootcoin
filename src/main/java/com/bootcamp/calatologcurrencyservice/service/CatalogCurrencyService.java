package com.bootcamp.calatologcurrencyservice.service;


import com.bootcamp.calatologcurrencyservice.model.CatalogEntity;
import com.bootcamp.calatologcurrencyservice.repository.CatalogCurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j

public class CatalogCurrencyService implements CatalogServiceRed {
    private final KafkaTemplate<String,CatalogEntity> kafkaTemplate;
    private final CatalogCurrencyRepository repository;
    private static final String TOPIC_NAME = "demo";


    @Override
    public Flux<CatalogEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<CatalogEntity> save(CatalogEntity client) {
        return repository.save(client);
    }

    @Override
    public Mono<CatalogEntity> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<CatalogEntity> create(CatalogEntity catalog) {
        return repository.insert(catalog)
                .map(this::sendToKafka);
    }


    @Override
    public Mono<CatalogEntity> update(CatalogEntity catalog) {
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }

    public CatalogEntity sendToKafka(CatalogEntity catalog) {
        kafkaTemplate.send(TOPIC_NAME, catalog.getId(), catalog)
                .addCallback(result -> {
                    var resultNonNull = Objects.requireNonNull(result);
                    log.info("response: {}", resultNonNull.getProducerRecord());
                }, Throwable::printStackTrace);
        return catalog;
    }
}
