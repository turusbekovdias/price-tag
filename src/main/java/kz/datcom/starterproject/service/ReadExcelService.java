package kz.datcom.starterproject.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.File;

@Service
public interface ReadExcelService {

    Mono<Void> readFile (File file);

}
