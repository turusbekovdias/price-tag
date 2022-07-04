package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.SampleDTO;
import kz.datcom.pricetag.mapper.SampleEntityMapper;
import kz.datcom.pricetag.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@RefreshScope // use this annotation to fetch @Value from config server
@Slf4j
@RequiredArgsConstructor
public class SampleService {

  @Value("${message:default-message}")
  private String configMessage;

  private final SampleEntityMapper sampleEntityMapper;
  private final SampleRepository sampleRepository;
  private final AtomicInteger counter = new AtomicInteger(0);

  // todo: Reactive example of controller's GET method + using mapper
  public Flux<SampleDTO> getSamples() {
    return Flux.just(new SampleDTO("NYSE", 100));
  }

  public Mono<String> getConfigMessage() {
    return Mono.just(configMessage);
  }

  public String convertToUpperCase(String message) {
    log.info("-------------------------------------");
    log.info("Consumed message: " + message);
    log.info("converting to uppercase, adding count and publishing....");
    log.info("-------------------------------------");
    return message.toUpperCase() + "_" + counter.getAndIncrement();
  }
}
