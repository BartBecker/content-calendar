package dev.bart.contentcalendar.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public record Content(
        @Id
        Integer id,
        @NotBlank
        String title,
        @NotBlank
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        @Future
        LocalDateTime dateUpdated,
        String url
) {
}
