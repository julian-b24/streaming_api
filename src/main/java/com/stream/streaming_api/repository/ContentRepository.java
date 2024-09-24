package com.stream.streaming_api.repository;

import com.stream.streaming_api.model.Content;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContentRepository extends CrudRepository<Content, UUID> {

    @Query(value = "SELECT * FROM content ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Content getRandomContent();

    List<Content> findAll(Sort sort);

}
