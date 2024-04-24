package dev.bart.contentcalendar.repository;

import dev.bart.contentcalendar.model.Content;
import dev.bart.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {


    // Query derivation
    List<Content> findAllByTitleContains(String keyword);

    @Query("""
            SELECT * FROM Content
            WHERE status = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);

}
