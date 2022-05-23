package kz.datcom.starterproject.repository;

import kz.datcom.starterproject.model.SampleEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SampleRepository extends ReactiveMongoRepository<SampleEntity, String> {
    Mono<SampleEntity> findFirstByOwner(String owner);
}
