package com.stream.streaming_api.repository;

import com.stream.streaming_api.model.Content;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContentRepository extends CrudRepository<Content, UUID> {
}
