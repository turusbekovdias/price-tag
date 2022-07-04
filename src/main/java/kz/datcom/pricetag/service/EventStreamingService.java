package kz.datcom.pricetag.service;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventStreamingService {

  private final SampleService sampleService;
  private final Faker faker = new Faker();

  /**
   * Takes messages from "test-input-topic" and puts them into "test-output-topic" with
   * some transformations
   *
   * @return
   */
  @Bean
  public Function<String, String> toUpperCase() {
    return sampleService::convertToUpperCase;
  }

  /**
   * Generates test "Fname Lname" pair every #pring.cloud.stream.poller.fixed-delay seconds
   * into the "test-input-topic"
   * @return
   */
  @Bean
  public Supplier<String> generateTestNames() {
    return () -> faker.name().fullName();
  }
}
