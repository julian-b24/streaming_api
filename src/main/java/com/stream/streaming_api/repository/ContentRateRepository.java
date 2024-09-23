package com.stream.streaming_api.repository;

import com.stream.streaming_api.model.ContentRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContentRateRepository extends CrudRepository<ContentRate, UUID> {

    @Query(value = "SELECT * FROM content_rate WHERE content_id = ?1", nativeQuery = true)
    List<ContentRate> findByContentId(UUID contentId);
}
