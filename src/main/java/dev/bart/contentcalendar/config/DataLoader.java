package dev.bart.contentcalendar.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.bart.contentcalendar.model.Content;
import dev.bart.contentcalendar.repository.ContentRepository;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

//@Profile("!dev")
@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Hello World!");

        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
            repository.saveAll(objectMapper.readValue(inputStream, new com.fasterxml.jackson.core.type.TypeReference<List<Content>>(){}));
        }
    }
}
