package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class SampleController {
    private final SampleService sampleService;

    @GetMapping("/hello")
    public Mono<String> getGreeting() {
        return sampleService.getConfigMessage();
    }
}
